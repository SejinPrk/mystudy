package app.myapp.handler.payment;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PaymentDao;

public class PaymentDeleteHandler extends AbstractMenuHandler {

  private PaymentDao paymentDao;

  public PaymentDeleteHandler(PaymentDao paymentDao, Prompt prompt) {
    super(prompt);
    this.paymentDao = paymentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (paymentDao.delete(no) == 0) {
      System.out.println("결제내역 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
