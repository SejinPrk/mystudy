package bitcamp.myapp.controller;

import bitcamp.myapp.config.RootConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  private final Log log = LogFactory.getLog(RootConfig.class);

  public HomeController() {

    log.debug("HomeController() 호출됨!");
  }

  @RequestMapping("/home")
  public String home()
      throws Exception {
    return "/home.jsp";
  }
}
