package bitcamp.myapp.servlet;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;
import static org.apache.coyote.http11.Constants.a;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<header>");
    out.println("  <img src=''>");
    out.println("  <a href=''>과제</a>");
    out.println("  <a href=''?>게시글</a>");
    out.println("  <a href=''?>회원</a>");
    out.println("  <a href=''?>가입인사</a>");
    out.println("</header>");
  }
}
