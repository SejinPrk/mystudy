package bitcamp.myapp.servlet.board;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServlet extends GenericServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    // this 가 가리키는 인스턴스의 클래스부터 service() 메서드를 찾아 올라간다.
    service(request, response);
  }

  protected void service (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  }
}
