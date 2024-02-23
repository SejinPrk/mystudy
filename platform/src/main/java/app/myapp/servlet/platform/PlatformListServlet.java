package app.myapp.servlet.platform;

import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/platform/list")
public class PlatformListServlet extends HttpServlet {

  private PlatformDao platformDao;

  @Override
  public void init() {
    platformDao= (PlatformDao) this.getServletContext().getAttribute("platformDao");
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

    out.println("<a href='/assignment/form.html'>새 플랫폼</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>이름</th> <th>가격</th> <th>결제주기</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Platform> list = platformDao.findAll();

      for (Platform platform : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/platform/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> </tr>\n",
            platform.getNo(),
            platform.getName(),
            platform.getPrice(),
            platform.getTerm());
      }
      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

