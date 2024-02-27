package app.myapp.servlet.category;

import app.myapp.dao.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category/delete")
public class CategoryDeleteServlet extends HttpServlet {

  private CategoryDao categoryDao;

  @Override
  public void init() {
    categoryDao =(CategoryDao) this.getServletContext().getAttribute("categoryDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      if (categoryDao.delete(no) == -1) {
        throw new Exception("분류 번호가 유효하지 않습니다.");
      }
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "삭제 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}