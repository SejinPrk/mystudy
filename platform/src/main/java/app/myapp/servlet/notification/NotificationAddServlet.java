package app.myapp.servlet.notification;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notification/add")
public class NotificationAddServlet extends HttpServlet {

  private NotificationDao notificationDao;

  @Override
  public void init() throws ServletException {
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

    out.println("<h1>플랫폼 관리 시스템</h1>");

    out.println("<h2>알림</h2>");

    out.println("<form action='/notification/add' method='post'>");
    out.println("<div>");
    out.println("     내용:  <textarea name='content'></textarea>");
    out.println("</div>");
    out.println("<div>");
    out.println("    날짜: <input name='date' type='date'>");
    out.println("</div>");
    out.println("<div>");
    out.println("   조회여부: <input name='check' type='checkbox'>");
    out.println("</div>");
    out.println("<div>");
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
      Notification notification = new Notification();
      notification.setContent(request.getParameter("content"));
      notification.setDate(Date.valueOf(request.getParameter("date")));
      notification.setCheck(Boolean.parseBoolean(request.getParameter("checked")));

      notificationDao.add(notification);
      response.sendRedirect("/notification/list");

    } catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}