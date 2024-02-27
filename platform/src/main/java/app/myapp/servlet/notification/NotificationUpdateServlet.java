package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/update")

public class NotificationUpdateServlet extends HttpServlet {

  private NotificationDao notificationDao;

  @Override
  public void init() {
    notificationDao = (NotificationDao) this.getServletContext().getAttribute("notificationDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));

      Notification old = notificationDao.findBy(no);
    if (old == null) {
      System.out.println("알림 번호가 유효하지 않습니다!");
    }

    Notification notification = new Notification();
    notification.setNo(old.getNo());
    notification.setContent(request.getParameter("content"));
    notification.setDate(Date.valueOf(request.getParameter("date")));
    notification.setCheck(Boolean.parseBoolean(request.getParameter("checked")));

    notificationDao.update(notification);
    response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
