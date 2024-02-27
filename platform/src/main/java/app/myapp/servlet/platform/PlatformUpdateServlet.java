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

@WebServlet("/platform/update")

public class PlatformUpdateServlet extends HttpServlet {

  private PlatformDao platformDao;

  @Override
  public void init() {
    platformDao = (PlatformDao) this.getServletContext().getAttribute("platformDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Platform old = platformDao.findBy(no);
      if (old == null) {
        throw new Exception("<p>플랫폼 번호가 유효하지 않습니다.</p>");
      }

      Platform platform = new Platform();
      platform.setNo(old.getNo());
      platform.setName(request.getParameter("name"));
      platform.setPrice(Integer.parseInt(request.getParameter("price")));
      platform.setTerm(request.getParameter("term"));

      platformDao.update(platform);
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}

