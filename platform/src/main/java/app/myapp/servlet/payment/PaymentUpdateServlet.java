package app.myapp.servlet.payment;

import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/payment/update")
public class PaymentUpdateServlet extends HttpServlet {

  private PaymentDao paymentDao;

  @Override
  public void init() {
    paymentDao = (PaymentDao) this.getServletContext().getAttribute("paymentDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));

      Payment old = paymentDao.findBy(no);
      if (old == null) {
        throw new Exception("결제내역 번호가 유효하지 않습니다.");
      }

    Payment payment = new Payment();
    payment.setNo(old.getNo());
    payment.setStart(Date.valueOf(request.getParameter("start")));
    payment.setEnd(Date.valueOf(request.getParameter("end")));
    payment.setAmount(Integer.parseInt(request.getParameter("amount")));

    paymentDao.update(payment);
    response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}