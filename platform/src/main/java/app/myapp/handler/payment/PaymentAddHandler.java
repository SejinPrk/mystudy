package app.myapp.handler.payment;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import java.util.Date;

public class PaymentAddHandler extends AbstractMenuHandler {

  private PaymentDao paymentDao;

  public PaymentAddHandler(PaymentDao paymentDao, Prompt prompt) {
    super(prompt);
    this.paymentDao = paymentDao;
  }

  @Override
  protected void action() {
    Payment payment = new Payment();
    payment.setStart(new Date("시작일: "));
    payment.setEnd(new Date("종료일: "));
    payment.setAmount(this.prompt.input("가격: "));

    paymentDao.add(payment);
  }
}
