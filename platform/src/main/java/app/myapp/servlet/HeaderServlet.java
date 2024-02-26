package app.myapp.servlet;

import app.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<header>");
    out.println(
        "  <img src='https://images.unsplash.com/photo-1621360841013-c7683c659ec6?q=80&w=2664&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D' height='80px'>");
    out.println("  <a href='/platform/list'>플랫폼</a>");
    out.println("  <a href='/category/list'>분류</a>");
    out.println("  <a href='/member/list'>회원</a>");
    out.println("  <a href='/notification/list'>알림</a>");
    out.println("  <a href='/payment/list'>결제내역</a>");
    out.println("  <a href='/subscription/list'>구독내역</a>");


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("  <a href='/auth/login'>로그인</a>");
    } else {
      out.printf("  <span>%s</span>\n", loginUser.getName());
      out.println("  <a href='/auth/logout'>로그아웃</a>");
    }

    out.println("  <a href='/about.html'>소개</a>");

    out.println("</header>");

  }
}
