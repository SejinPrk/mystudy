package bitcamp.myapp.controller;

import bitcamp.myapp.dao.MemberDao;
import org.springframework.stereotype.Component;

@Component
public class AboutController {

  public AboutController(MemberDao memberDao) {
    System.out.println("AboutController 호출됨!");

  }

  @RequestMapping("/about")
  public String about()
      throws Exception {
    return "/about.jsp";
  }
}
