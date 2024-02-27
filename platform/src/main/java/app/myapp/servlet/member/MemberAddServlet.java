package app.myapp.servlet.member;

import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

  private MemberDao memberDao;
  private String uploadDir;
  @Override
  public void init() {
    memberDao =(MemberDao) this.getServletContext().getAttribute("memberDao");
    uploadDir = this.getServletContext().getRealPath("/upload");

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
    out.println("<h2>회원</h2>");

    out.println("<form action='/member/add' method='post' enctype='multipart/form-data'>");

    out.println("<div>");
    out.println("    이메일: <input name='email' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    이름: <input name='name' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    암호: <input name='password' type='password'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    전화번호: <input tel='tel' type='text'>");
    out.println("</div>");
    out.println("  <div>");
    out.println("     사진: <input name='photo' type='file'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        카드번호: <input name='credit_no' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        유효기간: <input name='credit_date' type='text'>");
    out.println("  </div>");
    out.println("  <div>");
    out.println("        알림설정: <input name='notification' type='tinyint'>");
    out.println("  </div>");
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
      throws ServletException, IOException {
    try {
      response.setContentType("text/html;charset=UTF-8");

      Member member = new Member();
      member.setEmail(request.getParameter("email"));
      member.setName(request.getParameter("name"));
      member.setPassword(request.getParameter("password"));
      member.setTel(request.getParameter("tel"));
      member.setCreditNo(Integer.parseInt(request.getParameter("credit_no")));
      member.setCreditDate(request.getParameter("credit_date"));
      member.setNotification(Boolean.parseBoolean(request.getParameter("notification")));

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        member.setPhoto(filename);
        photoPart.write(this.uploadDir + "/" + filename);
      }
      memberDao.add(member);
      response.sendRedirect("list");


    } catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}



