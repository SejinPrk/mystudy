package app.myapp.handler.payment;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import app.util.Prompt;

public class PaymentViewHandler extends AbstractMenuHandler {

  private PaymentDao paymentDao;

  public PaymentViewHandler(PaymentDao paymentDao, Prompt prompt) {
    super(prompt);
    this.paymentDao = paymentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Payment payment = paymentDao.findBy(no);
    if (payment == null) {
      System.out.println("결제내역 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", payment.getNo());
    System.out.printf("시작일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", payment.getStart());
    System.out.printf("종료일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", payment.getEnd());
    System.out.printf("가격: %s\n", payment.getAmount());
  }
}
