package app.myapp.servlet.notification;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/update")

public class NotificationUpdateHandler extends HttpServlet {

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
    Notification old = notificationDao.findBy(no);
    if (old == null) {
      System.out.println("알림 번호가 유효하지 않습니다!");
      return;
    }

    Notification notification = new Notification();
    notification.setNo(old.getNo());
    notification.setContent(this.prompt.input("내용(%s):", old.getContent()));
    notification.setDate(this.prompt.input("날짜(%s): ", old.getDate()));
    notification.setCheck(this.prompt.input("조회여부(%s)", old.isCheck()));

    notificationDao.update(notification);
    System.out.println("알림을 변경했습니다.");
  }
}
