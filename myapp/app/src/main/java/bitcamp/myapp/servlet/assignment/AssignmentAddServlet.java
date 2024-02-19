package bitcamp.myapp.servlet.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/add")
public class AssignmentAddServlet extends HttpServlet {

  private TransactionManager txManager;
  private AssignmentDao assignmentDao;
  private AttachedFileDao attachedFileDao;



  public AssignmentAddServlet(TransactionManager txManager, AssignmentDao assignmentDao) {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    txManager = new TransactionManager(connectionPool);
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
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
    out.println("<h1>과제</h1>");

    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(request.getParameter("title"));
      assignment.setContent(request.getParameter("content"));
      assignment.setDeadline(Date.valueOf(request.getParameter(" "));

      txManager.startTransaction();

      assignmentDao.add(assignment);
      txManager.commit();
      out.println("<p>게시글을 등록했습니다.</p>");

      //txManager.rollback();
    }
      } catch (Exception e) {
      out.println("<p>게시글 등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
