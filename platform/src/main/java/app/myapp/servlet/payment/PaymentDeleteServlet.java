package app.myapp.servlet.payment;

import app.myapp.dao.PaymentDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/payment/delete")
public class PaymentDeleteServlet extends HttpServlet {

  private PaymentDao paymentDao;

  @Override
  public void init() {
    paymentDao = (PaymentDao) this.getServletContext().getAttribute("paymentDao");
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (paymentDao.delete(no) == 0) {
        throw new Exception("결제내역 번호가 유효하지 않습니다.");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "삭제 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}

