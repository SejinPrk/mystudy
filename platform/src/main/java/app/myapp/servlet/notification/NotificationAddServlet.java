package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/add")
public class NotificationAddServlet extends HttpServlet {

  private NotificationDao notificationDao;

  @Override
  public void init() throws ServletException {
    notificationDao = (NotificationDao) this.getServletContext().getAttribute("notificationDao");

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
    out.println("<h1>알림</h1>");

    try {
      Notification notification = new Notification();
      notification.setContent(request.getParameter("content"));
      notification.setDate(Date.valueOf(request.getParameter("date")));
      notification.setCheck(Boolean.parseBoolean(request.getParameter("checked")));

      notificationDao.add(notification);

      out.println("<p>등록했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}