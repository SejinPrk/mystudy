package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app1/c05_1/h1
  @GetMapping("h1")
  @ResponseBody
  public String handler1() {
    // 리턴 값이 클라이언트에게 보내는 콘텐트라면
    // 메서드 선언부에 @ResponseBody를 붙인다.
    // => 붙이지 않으면 프론트 컨트롤러는 view URL로 인식한다.
    // => 출력 콘텐트는 브라우저에서 기본으로 HTML로 간주한다.
    //    단 한글은 ISO-8859-1 문자표에 정의된 코드가 아니기 때문에
    //    클라이언트로 보낼 때 '?' 문자로 바꿔 보낸다.
    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app1/c05_1/h2
  // => 리턴되는 콘텐트의 MIME 타입과 charset을 지정하고 싶다면
  //    애노테이션의 produces 프로퍼티에 설정하라.
  @GetMapping(value = "h2", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    return "<html><body><h1>abc가각간<h1></body></html>";
  }
}
