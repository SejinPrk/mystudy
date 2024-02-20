package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import javax.servlet.http.HttpServlet;

public class NotificationDeleteHandler extends HttpServlet {

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
