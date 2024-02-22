package app.myapp.servlet.subscription;

import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subscription/update")

public class SubscriptionUpdateServlet extends HttpServlet {

  private SubscriptionDao subscriptionDao;

  @Override
  public void init() {
    subscriptionDao = (SubscriptionDao) this.getServletContext().getAttribute("subscriptionDao");
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
    out.println("<h1>구독내역</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Subscription old = subscriptionDao.findBy(no);
      if (old == null) {
        out.println("<p>구독내역 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Subscription subscription = new Subscription();
      subscription.setNo(old.getNo());
      subscription.setStart(Date.valueOf(request.getParameter("start")));
      subscription.setEnd(Date.valueOf((request.getParameter("end"))));

      subscriptionDao.update(subscription);
      System.out.println("</p>변경했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}

