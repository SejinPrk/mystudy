package app.myapp.handler.notification;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;

public class NotificationModifyHandler extends AbstractMenuHandler {

  private NotificationDao notificationDao;

  public NotificationModifyHandler(NotificationDao notificationDao, Prompt prompt) {
    super(prompt);
    this.notificationDao =  notificationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

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
