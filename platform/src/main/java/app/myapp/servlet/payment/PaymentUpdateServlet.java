package app.myapp.servlet.payment;

import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import javax.servlet.http.HttpServlet;

public class PaymentUpdateServlet extends HttpServlet {

  private PaymentDao paymentDao;

  public PaymentUpdateServlet(PaymentDao paymentDao, Prompt prompt) {
    super(prompt);
    this.paymentDao = paymentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Payment oldPayment= paymentDao.findBy(no);
    if (oldPayment == null) {
      System.out.println("결제내역 번호가 유효하지 않습니다.");
      return;
    }

    Payment payment = new Payment();
    payment.setNo(oldPayment.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    payment.setStart(oldPayment.getStart());
    payment.setEnd(oldPayment.getEnd());
    payment.setAmount(this.prompt.input("가격(%s)? ", oldPayment.getAmount()));

    paymentDao.update(payment);
    System.out.println("결제내역을 변경했습니다.");
  }
}
