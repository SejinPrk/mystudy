package app.myapp.handler.payment;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import app.util.Prompt;
import java.util.List;

public class PaymentListHandler extends AbstractMenuHandler {

  private PaymentDao paymentDao;

  public PaymentListHandler(PaymentDao paymentDao, Prompt prompt) {
    super(prompt);
    this.paymentDao = paymentDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Start", "End", "Amount");

    List<Payment> list = paymentDao.findAll();

    for (Payment payment : list) {
      System.out.printf("%-4d\t%4$tY-%4$tm-%4$td\t%4$tY-%4$tm-%4$td\t%10s\n",
          payment.getNo(),
          payment.getStart(),
          payment.getEnd(),
          payment.getAmount());
    }
  }
}
