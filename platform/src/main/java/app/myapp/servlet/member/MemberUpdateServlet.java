package app.myapp.servlet.member;

import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() {
    memberDao =(MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
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
    out.println("<h1>회원</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member old = memberDao.findBy(no);
      if (old == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Member member = new Member();
      member.setNo(old.getNo());
      member.setEmail(request.getParameter("email"));
      member.setName(request.getParameter("name"));
      member.setPassword(request.getParameter("password"));
      member.setTel(request.getParameter("tel"));
      member.setCreatedDate(old.getCreatedDate());

      memberDao.update(member);
      System.out.println("회원을 변경했습니다.");
    } catch (Exception e) {
      out.println("<p>변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
