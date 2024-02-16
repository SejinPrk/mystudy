package bitcamp.myapp.handler.auth;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class LoginHandler extends GenericServlet {

  MemberDao memberDao;

  public LoginHandler() {

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

    String email = servletRequest.getParameter("email");
    String password = servletRequest.getParameter("password");

    Member member = memberDao.findByEmailAndPassword(email, password);
    if (member != null) {
      servletRequest.getSession().setAttribute("loginUser", member);
      prompt.printf("%s 님 환영합니다.\n", member.getName());
    } else {
      prompt.println("이메일 또는 암호가 맞지 않습니다.");
    }
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
