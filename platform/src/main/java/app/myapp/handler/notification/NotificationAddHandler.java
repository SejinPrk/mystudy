package app.myapp.handler.notification;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.util.Date;

public class NotificationAddHandler extends AbstractMenuHandler {

  private NotificationDao notificationDao;

  public NotificationAddHandler(NotificationDao notificationDao, Prompt prompt) {
    super(prompt);
    this.notificationDao = notificationDao;
  }

  @Override
  protected void action() {
    Notification notification = new Notification();
    notification.setContent(this.prompt.input("내용: "));
    notification.setDate(new Date("날짜: "));
    notification.setContent(this.prompt.input("조회여부: "));
    notificationDao.add(notification);
  }
}
