package app.myapp.servlet.category;

import app.myapp.dao.CategoryDao;
import app.myapp.vo.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category/list")
public class CategoryListServlet extends HttpServlet {

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

    out.println("<h1>분류</h1>");

    out.println("<a href='/member/add'>새 분류</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>이름</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Category> list = categoryDao.findAll();

      for (Category category : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/category/view?no=%1$d'>%s</a></td> </tr>\n",
            category.getNo(),
            category.getName());
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
