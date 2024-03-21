package bitcamp.myapp.controller;

import bitcamp.myapp.config.RootConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
  private final Log log = LogFactory.getLog(RootConfig.class);

  public AboutController() {
    log.debug("AboutController() 호출됨!");
  }

  @RequestMapping("/about")
  public String about()
      throws Exception {
    return "/about.jsp";
  }
}
