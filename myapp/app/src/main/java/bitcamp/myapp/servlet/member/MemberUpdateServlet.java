package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private MemberDao memberDao;
  private AttachedFileDao attachedFileDao;

  public MemberUpdateServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    txManager = new TransactionManager(connectionPool);
    this.memberDao = new MemberDaoImpl(connectionPool);
    this.attachedFileDao = new AttachedFileDaoImpl(connectionPool);
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
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인하시기 바랍니다!</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try{
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
    }

    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
    String[] files = request.getParameterValues("files");
    if (files != null) {
      for (String file : files) {
        if (file.length() == 0) {
          continue;
        }
        attachedFiles.add(new AttachedFile().filePath(file));
      }
    }

      txManager.startTransaction();

      memberDao.update(member);

      if (attachedFiles.size() > 0) {
        for (AttachedFile attachedFile : attachedFiles) {
          attachedFile.setBoardNo(member.getNo());
        }
        attachedFileDao.addAll(attachedFiles);
      }

      txManager.commit();

      out.println("<p>회원을 변경했습니다.</p>");

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>회원 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}