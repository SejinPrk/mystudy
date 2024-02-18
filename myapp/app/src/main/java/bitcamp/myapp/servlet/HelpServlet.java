package bitcamp.myapp.servlet;

import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/help/view")
public class HelpServlet extends HttpServlet {
  public HelpServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
  }
}
@Override
  protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("도움말입니다.");
    } catch (Exception e) {
        out.println("<p>조회 오류!</p>");
        out.println("<pre>");
        e.printStackTrace(out);
        out.println("</pre>");
    }
  }

