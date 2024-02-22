package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/view")
public class NotificationViewHandler extends HttpServlet {

  private NotificationDao notificationDao;
  @Override
  public void init() {
    notificationDao = (NotificationDao) this.getServletContext().getAttribute("notificationDao");
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
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>알림</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));


      Notification notification = notificationDao.findBy(no);
    if (notification == null) {
      System.out.println("<p>알림 번호가 유효하지 않습니다!</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

      out.println("<form action='/notification/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", notification.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  내용: <textarea name='content'>%s</textarea>\n", notification.getContent());
      out.println("</div>");
      out.println("<div>");
      out.printf("  날짜: <input name='date' type='Date' value='%s'>\n", notification.getDate());
      out.println("</div>");
      out.println("<div>");
      out.printf("  조회여부: <input name='checked' type='boolean' value='%s'>\n", notification.isCheck());
      out.println("</div>");
      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/notification/delete?no=%d'>[삭제]</a>\n", no);
      out.println("</div>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}
