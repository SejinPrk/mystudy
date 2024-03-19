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

    // 기본 ViewResolver를 사용할 때는
    // 뷰 이름을 리턴하지 않으면, request handler의 URL을 사용한다.
    //  즉 다음 return 문장을 작성한 것과 같다.
    //  return "/c01_1/h2";
    //
    // Spring WebMVC의 기본 설정된 ViewResolver는
    // 페이지 컨트롤러가 리턴한 URL을 가지고 view URL을 계산한다.
    // 계산 방법:
    // =>  현재 URL = /app2/c01_1/h2
    // => view URL = 현재 URL의 경로 + request handler의 리턴 값
    //             = /app2/c01_1 + /c01_1/h2
    //             = /app2/c01_1/c01_1/h2
    //
    //    따라서 잘못 계산된 view URL로 JSP를 찾으니까 오류가 발생한다!
    //
    //
    // InternalResourceViewResolver로 교체한 다음은?
    // => 리턴 값이 없으면 요청 URL(/c01_1/h2)을 리턴 값으로 사용한다.
    // => 따라서 ViewResolver가 계산한 최종 URL은
    // /WEB-INF/jsp2/c01_1/h2.jsp
    //
  }


}
