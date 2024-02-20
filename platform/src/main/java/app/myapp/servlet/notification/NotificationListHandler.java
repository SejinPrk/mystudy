package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.util.List;
import javax.servlet.http.HttpServlet;

public class NotificationListHandler extends HttpServlet {

  private NotificationDao notificationDao;

  public NotificationListHandler(NotificationDao notificationDao, Prompt prompt) {
    super(prompt);
    this.notificationDao = notificationDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "내용", "날짜", "조회여부");

    List<Notification> list = notificationDao.findAll();

    for (Notification notification : list) {
      System.out.printf("%-4d\t%-20s\t%s\n",
          notification.getContent(),
          notification.getDate(),
          notification.isCheck());
    }
  }
}
