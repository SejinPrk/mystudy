package app.myapp.handler.subscription;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
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

    Subscription subscription= subscriptionDao.findBy(no);
    if (subscription == null) {
      System.out.println(" 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("구독시작일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", subscription.getStart());
    System.out.printf("구독종료일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", subscription.getEnd());
  }
}