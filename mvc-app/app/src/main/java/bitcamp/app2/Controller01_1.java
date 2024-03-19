package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c01_1")
public class Controller01_1 {

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_1/h1
  @GetMapping("h1")
  // @ResponseBody // 뷰 이름을 리턴 할 때는 이 애노테이션을 붙이면 안된다.
  public String handler1(Model model) {

    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);

    return "/jsp/c01_1.jsp";
    // 기본 ViewResolver는 리턴 값으로 URL을 받아
    // 웹 애플리케이션 디렉토리에서 JSP를 찾는다.
    // 웹 애플리케이션이 경로가 /eomcs-spring-webmvc 라면,
    // JSP 경로는 다음과 같다.
    // ==> /eomcs-spring-webmvc/jsp/c01_1.jsp
    //
    // InternalResourceViewResolver로 교체한 다음의 JSP URL은?
    // => /WEB-INF/jsp2//jsp/c01_1.jsp.jsp
  }


  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_1/h2
  @GetMapping("h2")
  public void handler2(Model model) {
    model.addAttribute("name", "홍길동2");
    model.addAttribute("age", 30);

    // 뷰 이름을 리턴하지 않으면
    // request handler의 URL을 기준으로 view URL을 계산한다.
    // =>  현재 URL = /c01_1/h2
    // => view URL = 현재 URL의 경로 + request handler URL
    //             = /c01_1
    // 오류 발생!
    //
    // InternalResourceViewResolver로 교체한 다음은?
    // => 리턴 값이 없으면 요청 URL(/c01_1/h2)을 리턴 값으로 사용한다.
    // => 따라서 ViewResolver가 계산한 최종 URL은
    // /WEB-INF/jsp2/c01_1/h2.jsp
    //

  }
}
