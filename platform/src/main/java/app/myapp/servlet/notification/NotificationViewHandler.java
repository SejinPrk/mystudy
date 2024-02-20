package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/view")
public class NotificationViewHandler extends HttpServlet {

  private NotificationDao notificationDao;
  @Override
  public void init() {
    notificationDao = (NotificationDao) this.getServletContext().getAttribute("notificationDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    Notification notification = notificationDao.findBy(no);
    if (notification == null) {
      System.out.println("알림 번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("번호: %d\n", notification.getNo());
    System.out.printf("내용: %s\n", notification.getContent());
    System.out.printf("날짜: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", notification.getDate());
    System.out.printf("조회여부: %s\n", notification.isCheck());
  }
}
