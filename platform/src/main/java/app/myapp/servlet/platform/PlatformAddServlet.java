package app.myapp.servlet.platform;

import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/platform/add")
public class PlatformAddServlet extends HttpServlet {

  private PlatformDao platformDao;

  @Override
  public void init() {
    platformDao = (PlatformDao) this.getServletContext().getAttribute("platformDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>개인과제</title>");
    out.println("</head>");
    out.println("<body>");

    request.getRequestDispatcher("/header").include(request, response);

    out.println("<h1>플랫폼 관리 시스템</h1>");

    out.println("<h2>플랫폼</h2>");

    out.println("<form action='/platform/add' method='post'>");
    out.println("<div>");
    out.println("    플랫폼: <input name='title' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    이름: <input name='name'></in>");
    out.println("</div>");
    out.println("<div>");
    out.println("    가격: <input name='price'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    결제주기: <input name='term'>");
    out.println("</div>");
    out.println("<div>");
    out.println("<button>등록</button>");
    out.println("</div>");
    out.println("</form>");

    request.getRequestDispatcher("/footer").include(request, response);

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws IOException, ServletException {
    try {
      Platform platform = new Platform();
      platform.setName(request.getParameter("name"));
      platform.setPrice(Integer.parseInt(request.getParameter("price")));
      platform.setTerm(request.getParameter("term"));

      platformDao.add(platform);
      response.sendRedirect("/platform/list");

    }  catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}