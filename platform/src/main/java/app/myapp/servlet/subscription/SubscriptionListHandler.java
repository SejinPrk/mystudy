package app.myapp.servlet.subscription;

import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.util.List;
import javax.servlet.http.HttpServlet;

public class SubscriptionListHandler extends HttpServlet {

  private SubscriptionDao subscriptionDao;

  public SubscriptionListHandler(SubscriptionDao subscriptionDao, Prompt prompt) {
    super(prompt);
    this.subscriptionDao = subscriptionDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%s\n", "Start", "End");

    List<Subscription> list = subscriptionDao.findAll();

    for (Subscription subscription : list) {
      System.out.printf("%t%4$tY-%4$tm-%4$td\t%4$tY-%4$tm-%4$td\n",
          subscription.getStart(),
          subscription.getEnd();
    }
  }
}
