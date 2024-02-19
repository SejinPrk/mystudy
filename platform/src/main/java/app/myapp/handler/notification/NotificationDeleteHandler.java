package app.myapp.handler.notification;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;

public class NotificationDeleteHandler extends AbstractMenuHandler {

  private NotificationDao notificationDao;

  public NotificationDeleteHandler(NotificationDao notificationDao, Prompt prompt) {
    super(prompt);
    this.notificationDao = notificationDao();
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (notificationDao.delete(no) == -1) {
      System.out.println("알림 번호가 유효하지 않습니다!");
    } else {
      System.out.println("알림을 삭제했습니다.");
    }
  }
}
