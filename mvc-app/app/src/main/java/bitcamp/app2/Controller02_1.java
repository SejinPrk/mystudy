// URL 에서 값 추출하기 - @PathVariable
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_1")
public class Controller02_1 {

  @GetMapping
  @ResponseBody
  public String handler1(String name, int age) {
    // 클라이언트로부터 값을 받는 일반적인 방법
    // => Query String 으로 받는다.
    // => 즉 URL 다음에 "?변수=값&변수=값" 형태로 값을 받는다.
    // => Query String의 값을 request handler에서 받으려면
    //    아규먼트를 선언하면 된다.
    //    아규먼트 앞에 @RequestParam을 붙여도 되고
    //    아규먼트이 이름이 요청 파라미터의 이름과 같다면 @RequestParam을 생략해도 된다.
    return String.format("name=%s, age=%d", name, age);
  }

  @GetMapping("{name}/{age}")
  @ResponseBody
  public String handler2(
      @PathVariable String name,
      @PathVariable int age
  ) {
    return String.format("name=%s, age=%d", name, age);
  }

  @GetMapping("{name}_{age}")
  @ResponseBody
  public String handler3(
      @PathVariable String name,
      @PathVariable int age
  ) {
    return String.format("name=%s, age=%d", name, age);
  }
}