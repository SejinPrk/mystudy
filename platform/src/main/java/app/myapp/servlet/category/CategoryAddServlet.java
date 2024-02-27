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

@WebServlet("/category/add")
public class CategoryAddServlet extends HttpServlet {

  private CategoryDao categoryDao;

  @Override
  public void init() {
    categoryDao =(CategoryDao) this.getServletContext().getAttribute("categoryDao");
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

    out.println("<h2>분류</h2>");

    out.println("<form action='/category/add' method='post'>");
    out.println("<div>");
    out.println("    이름: <input name='name' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("<button>등록</button>");
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
      Category category = new Category();
      category.setName(request.getParameter("name"));

      categoryDao.add(category);
      response.sendRedirect("/category/list");

    } catch (Exception e) {
      request.setAttribute("message", "등록 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}

