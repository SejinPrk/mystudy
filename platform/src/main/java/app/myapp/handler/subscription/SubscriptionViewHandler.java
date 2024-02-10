package app.myapp.handler.subscription;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.NotificationDao;
import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Notification;
import app.util.Prompt;

public class SubscriptionViewHandler extends AbstractMenuHandler {

  private SubscriptionDao subscriptionDao;

  public SubscriptionViewHandler(SubscriptionDao subscriptionDao, Prompt prompt) {
    super(prompt);
    this.subscriptionDao = subscriptionDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Notification board = boardDao.findBy(no);
    if (board == null) {
      System.out.println(" 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("구독시작일: %d\n", subscription.getNo());
    System.out.printf("구독종료일: %s\n", board.getTitle());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
  }
}
