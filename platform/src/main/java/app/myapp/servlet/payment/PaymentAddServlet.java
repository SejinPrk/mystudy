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

@WebServlet("/payment/add")
public class PaymentAddServlet extends HttpServlet {

  private PaymentDao paymentDao;

  @Override
  public void init() {
    paymentDao = (PaymentDao) this.getServletContext().getAttribute("paymentDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>개인과제</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>결제내역</h1>");

    try{
    Payment payment = new Payment();

      payment.setStart(Date.valueOf(request.getParameter("start")));
    payment.setEnd(Date.valueOf(request.getParameter("end")));
    payment.setAmount(Integer.parseInt(request.getParameter("amount")));

    paymentDao.add(payment); out.println("<p>등록했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}