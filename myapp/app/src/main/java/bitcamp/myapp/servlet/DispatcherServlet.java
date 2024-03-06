package bitcamp.myapp.servlet;

import bitcamp.myapp.controller.AssignmentController;
import bitcamp.myapp.controller.AuthController;
import bitcamp.myapp.controller.BoardController;
import bitcamp.myapp.controller.HomeController;
import bitcamp.myapp.controller.MemberController;
import bitcamp.myapp.controller.RequestMapping;
import bitcamp.myapp.controller.RequestParam;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

  private Map<String, RequestHandler> requestHandlerMap = new HashMap<>();
  private List<Object> controllers = new ArrayList<>();

  @Override
  public void init() throws ServletException {
    ServletContext ctx = this.getServletContext();
    TransactionManager txManager = (TransactionManager) ctx.getAttribute("txManager");
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
    AssignmentDao assignmentDao = (AssignmentDao) ctx.getAttribute("assignmentDao");
    AttachedFileDao attachedFileDao = (AttachedFileDao) ctx.getAttribute("attachedFileDao");

    controllers.add(new HomeController());
    controllers.add(new AssignmentController(assignmentDao));
    controllers.add(new AuthController(memberDao));

    String boardUploadDir = this.getServletContext().getRealPath("/upload/board");
    controllers.add(new BoardController(txManager, boardDao, attachedFileDao, boardUploadDir));

    String memberUploadDir = this.getServletContext().getRealPath("/upload");
    controllers.add(new MemberController(memberDao, memberUploadDir));

    prepareRequestHandlers(controllers);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // URL 요청을 처리할 request handler를 찾는다.
      RequestHandler requestHandler = requestHandlerMap.get(request.getPathInfo());
      if (requestHandler == null) {
        throw new Exception(request.getPathInfo() + " 요청 페이지를 찾을 수 없습니다.");
      }

      Object[] args = prepareRequestHandlerArguments(requestHandler.handler, request, response);

      String viewUrl = (String) requestHandler.handler.invoke(requestHandler.controller, args);

      // 페이지 컨트롤러가 알려준 JSP로 포워딩 한다.
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        request.getRequestDispatcher(viewUrl).forward(request, response);
      }

    } catch (Exception e) {
      // 페이지 컨트롤러에서 오류가 발생했으면 오류페이지로 포워딩한다.
      request.setAttribute("message", request.getPathInfo() + " 실행 오류!");

      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      request.setAttribute("detail", stringWriter.toString());

      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }

  private void prepareRequestHandlers(List<Object> controllers) {
    for (Object controller : controllers) {
      Method[] methods = controller.getClass().getDeclaredMethods();
      for (Method m : methods) {
        RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
        if (requestMapping != null) {
          requestHandlerMap.put(requestMapping.value(), new RequestHandler(controller, m));
        }
      }
    }
  }

  private Object[] prepareRequestHandlerArguments(
      Method handler,
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    // 요청 핸들러의 파라미터 정보를 알아낸다.
    Parameter[] methodParams = handler.getParameters();

    // 파라미터에 전달할 값을 담을 배열을 준비한다.
    Object[] args = new Object[methodParams.length];

    // 파라미터를 분석하여 각 파라미터에 맞는 값을 배열에 담는다.
    for (int i = 0; i < args.length; i++) {
      Parameter methodParam = methodParams[i];
      if (methodParam.getType() == HttpServletRequest.class
          || methodParam.getType() == ServletRequest.class) {
        args[i] = request;
      } else if (methodParam.getType() == HttpServletResponse.class
          || methodParam.getType() == ServletResponse.class) {
        args[i] = response;
      } else {
        RequestParam requestParam = methodParam.getAnnotation(RequestParam.class);
        String requestParameterName = requestParam.value();
        String requestParameterValue = request.getParameter(requestParameterName);
        Object value = valueOf(requestParameterValue, methodParam.getType());
        if (value != null) {
          // 파라미터 타입이 primitive data type, String, Date 일 경우
          // 문자열로 받은 요청 파라미터 값을 해당 타입의 값으로 변환하여 저장한다.
          args[i] = value;
        }
        else {
          // request handler 가 원하는 값이 Domain 객체라면,
          // 도메인 객체를 생성한 후
          // 도메인 객체의 프로퍼티 이름과 일치하는 요청 파라미터 값을 담아서 준다.

          // 1) 도메인 클래스의 생성자 알아냄
          Constructor constructor = methodParam.getType().getConstructor();

          // 2) 생성자를 이용하여 도메인 객체 생성
          Object obj = constructor.newInstance();

          // 3) 도메인 클래스 메서드 목록을 가져옴
          Method[] methods = methodParam.getType().getClass().getDeclaredMethods();

          // 4) 메서드 중에서 Setter 메서드를 알아냄
          for (Method m : methods) {
            if (!m.getName().startsWith("set")) {
              continue;
            }

            // 5) Setter 메서드의 이름에서 프로퍼티 이름을 추출
            // 예) setFirstName ==> FirstName
            String propName = Character.toLowerCase(m.getName().charAt(3)) + m.getName().substring(4);

           // 6) 프로퍼티 이름으로 넘어온 요청 파라미터 값을 꺼낸다.
           String requestParamValue = request.getParameter(propName);

           // 7) 도메인 객체의 프로퍼티 이름과 일치하는 요청 파라미터 값이 있다면 객체에 저장한다.
           if (requestParamValue != null) {
             m.invoke(obj, requestParamValue);
           }
          }
        }
      }
    }

    return args;
  }

  // 문자열을 주어진 타입으로 변환하여 리턴한다.
  private Object valueOf(String strValue, Class<?> type) {
    if (type == byte.class) {
      return Byte.parseByte(strValue);
    } else if (type == short.class) {
      return Short.parseShort(strValue);
    } else if (type == int.class) {
      return Integer.parseInt(strValue);
    } else if (type == long.class) {
      return Long.parseLong(strValue);
    } else if (type == float.class) {
      return Float.parseFloat(strValue);
    } else if (type == double.class) {
      return Double.parseDouble(strValue);
    } else if (type == boolean.class) {
      return Boolean.parseBoolean(strValue);
    } else if (type == char.class) {
      return strValue.charAt(0);
    } else if (type == Date.class) {
      return Date.valueOf(strValue);
    } else if (type == String.class) {
      return strValue;
    } else {
      return null;
    }
  }
}
