package bitcamp.myapp.servlet.auth;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import javax.servlet.annotation.WebServlet;

@WebServlet("/auth/login")
public class LoginServlet extends GenericServlet {

  MemberDao memberDao;

  public LoginServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new MemberDaoImpl(connectionPool);
  }

  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    // 서블릿 컨테이너가 service()를 호출할 때 넘겨주는 값을
    // HttpServletRequest와 HttpServletResponse이다.
    // 파라미터로 넘어온 객체를 제대로 사용하고 싶다면 원래 타입으로 형변환하라!
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<h2>로그인</h2>");

    try {
      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
        request.getSession().setAttribute("loginUser", member);
        prompt.printf("<p>%s 님 환영합니다.</p>\n", member.getName());
      } else {
        prompt.println("이메일 또는 암호가 맞지 않습니다.");
      }
    } catch (Exception e) {
      out.println("<p>로그인 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
  }
}

  protected void action(Prompt prompt) {
    String email = prompt.input("이메일? ");
    String password = prompt.input("암호? ");

    Member member = memberDao.findByEmailAndPassword(email, password);
    if (member != null) {
//      prompt.setLoginUser(member);
//      prompt.setAttribute("loginUser", member);
      prompt.getSession().setAttribute("loginUser", member);
      prompt.printf("%s 님 환영합니다.\n", member.getName());
    } else {
      prompt.println("이메일 또는 암호가 맞지 않습니다.");
    }
  }
}
