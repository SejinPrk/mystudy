package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/list")

public class NotificationListServlet extends HttpServlet {

  private NotificationDao notificationDao;

  @Override
  public void init() {
    notificationDao = (NotificationDao) this.getServletContext().getAttribute("notificationDao");
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

    out.println("<h1>알림</h1>");

    out.println("<a href='/notification/add'>새 알림</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>내용</th> <th>날짜</th> <th>조회여부</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

    List<Notification> list = notificationDao.findAll();

    for (Notification notification : list) {
      out.printf("<tr> <td>%d</td> <td><a href='/notification/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> </tr>\n",
          notification.getNo(),
          notification.getContent(),
          notification.getDate(),
          notification.isCheck());
    }
      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      request.setAttribute("message", "목록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }

    request.getRequestDispatcher("/footer").include(request, response);

    out.println("</body>");
    out.println("</html>");
  }
}
