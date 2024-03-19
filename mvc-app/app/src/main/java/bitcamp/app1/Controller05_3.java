package bitcamp.app1;

import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c05_3")
public class Controller05_3 {

  // 테스트:
  //   http://localhost:9999/eomcs-spring-webmvc/app1/c05_3/h1
  @GetMapping("h1")
  public String handler1(
      ServletRequest request) {

    // JSP가 꺼내 쓸 수 있도록 ServletRequest 객체에 직접 담는다.
    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20); // auto-boxing: int ===> Integer 객체
    request.setAttribute("working", true); // auto-boxing: boolean ===> Boolean 객체

    return "/WEB-INF/jsp/c05_3.jsp";
  }

}
