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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));

      Subscription old = subscriptionDao.findBy(no);
      if (old == null) {
        throw new Exception("구독내역 번호가 유효하지 않습니다.");
      }

      Subscription subscription = new Subscription();
      subscription.setNo(old.getNo());
      subscription.setStart(Date.valueOf(request.getParameter("start")));
      subscription.setEnd(Date.valueOf((request.getParameter("end"))));

      subscriptionDao.update(subscription);
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}