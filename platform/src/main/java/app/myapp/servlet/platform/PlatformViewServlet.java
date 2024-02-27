package app.myapp.servlet.platform;

import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/platform/view")
public class PlatformViewServlet extends HttpServlet {

  private PlatformDao platformDao;

  @Override
  public void init() {
    platformDao = (PlatformDao) this.getServletContext().getAttribute("platformDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Platform platform = platformDao.findBy(no);
      if (platform == null) {
        throw new Exception("<p>플랫폼 번호가 유효하지 않습니다.</p>");
      }

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

      out.println("<h1>플랫폼</h1>");
      out.println("<form action='/platform/update' method='post'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", platform.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  플랫폼명: <input name='name' type='text' value='%s'>\n", platform.getName());
      out.println("</div>");
      out.println("<div>");
      out.printf("  가격: <textarea name='price'>%s</textarea>\n", platform.getPrice());
      out.println("</div>");
      out.println("<div>");
      out.printf("  결제주기: <textarea name='term'>%s</textarea>\n", platform.getTerm());
      out.println("</div>");
      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/platform/delete?no=%d'>[삭제]</a>\n", no);
      out.println("</div>");
      out.println("</form>");

      request.getRequestDispatcher("/footer").include(request, response);

      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      request.setAttribute("message", "조회 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
