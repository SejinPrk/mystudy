package app.myapp.servlet.subscription;

import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subscription/list")
public class SubscriptionListServlet extends HttpServlet {

  private SubscriptionDao subscriptionDao;

  @Override
  public void init() {
    subscriptionDao= (SubscriptionDao) this.getServletContext().getAttribute("subscriptionDao");
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

    out.println("<a href='/subscription/form.html'>새 구독내역</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>시작일</th> <th>종료일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Subscription> list = subscriptionDao.findAll();

      for (Subscription subscription : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/subscription/view?no=%1$d'>%s</a></td> <td>%s</td></tr>\n",
            subscription.getNo(),
            subscription.getStart(),
            subscription.getEnd());
      }
      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

