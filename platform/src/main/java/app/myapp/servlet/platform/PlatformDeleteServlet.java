package app.myapp.servlet.platform;

import app.myapp.dao.PlatformDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/platform/delete")
public class PlatformDeleteServlet extends HttpServlet {

  private PlatformDao platformDao;

  @Override
  public void init() {
    platformDao = (PlatformDao) this.getServletContext().getAttribute("platformDao");
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
    out.println("<h1>플랫폼</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (platformDao.delete(no) == 0) {
        out.println("<p>플랫폼 번호가 유효하지 않습니다.</p>");
      } else {
        out.println("<p>삭제했습니다.</p>");
      }

    } catch (Exception e) {
      out.println("<p>삭제 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
