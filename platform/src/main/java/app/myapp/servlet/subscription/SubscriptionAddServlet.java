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

@WebServlet("/subscription/add")
public class SubscriptionAddServlet extends HttpServlet {

  private SubscriptionDao subscriptionDao;

  @Override
  public void init() {
    subscriptionDao = (SubscriptionDao) this.getServletContext().getAttribute("subscriptionDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

    request.getRequestDispatcher("/header").include(request, response);

    out.println("<h1>플랫폼 관리 시스템</h1>");

    out.println("<h2>구독내역</h2>");

    out.println("<form action='/subscription/add' method='post'>");
    out.println("<div>");
    out.println("    시작일: <input name='start' type='date'>");
    out.println("</div>");
    out.println("<div>");
    out.println("    종료일: <input name='end' type='date'>");
    out.println("</div>");
    out.println(" <div>");
    out.println(" <button>등록</button>");
    out.println("</div>");
    out.println("</form>");

    request.getRequestDispatcher("/footer").include(request, response);

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Subscription subscription = new Subscription();
      subscription.setStart(Date.valueOf(request.getParameter("start")));
      subscription.setEnd(Date.valueOf(request.getParameter("end")));

      subscriptionDao.add(subscription);
      response.sendRedirect("/assignment/list");

    } catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
