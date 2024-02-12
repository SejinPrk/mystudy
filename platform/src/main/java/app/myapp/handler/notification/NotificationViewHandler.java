package app.myapp.handler.notification;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import app.util.Prompt;


public class NotificationViewHandler extends AbstractMenuHandler {

  private NotificationDao notificationDao;

  public NotificationViewHandler(NotificationDao notificationDao, Prompt prompt) {
    super(prompt);
    this.notificationDao = notificationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

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
