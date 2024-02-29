package bitcamp.myapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController implements PageController {
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    return "/home.jsp";
  }
}
