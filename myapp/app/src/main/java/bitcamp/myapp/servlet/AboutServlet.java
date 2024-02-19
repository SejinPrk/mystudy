package bitcamp.myapp.servlet;

import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about/view")
public class AboutServlet extends HttpServlet {
  private TransactionManager txManager;
  public AboutServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
  }
  protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("비트캠프 네이버 데브옵스 과정 5기");
    out.println("MyAPP ver. 49");
    out.println("모든 권리는 비트캠프에 있습니다.");
  }
}
