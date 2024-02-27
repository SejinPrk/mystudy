package app.myapp.servlet.category;

import app.myapp.dao.CategoryDao;
import app.myapp.vo.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/category/update")
public class CategoryUpdateServlet extends HttpServlet {

  private CategoryDao categoryDao;

  @Override
  public void init() {
    categoryDao =(CategoryDao) this.getServletContext().getAttribute("categoryDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));

      Category old = categoryDao.findBy(no);
      if (old == null) {
        throw new Exception("분류 번호가 유효하지 않습니다.");
      }

      Category category = new Category();
      category.setNo(old.getNo());
      category.setName(request.getParameter("name"));

      categoryDao.update(category);
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
