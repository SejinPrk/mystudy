package app.myapp.controller;

import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlatformController {

  private PlatformDao platformDao;

  public PlatformController(PlatformDao platformDao) {
    System.out.println("PlatformController() 호출됨!");
    this.platformDao = platformDao;
  }

  @RequestMapping("/platform/form")
  public String form() throws Exception {
    return "/platform/form.jsp";
  }

  @RequestMapping("/platform/add")
  public String add(Platform platform) throws Exception {
    System.out.println(platform);
    platformDao.add(platform);
    return "redirect:list";
  }

  @RequestMapping("/platform/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", platformDao.findAll());
    return "/platform/list.jsp";
  }
  @RequestMapping("/platform/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Platform platform = platformDao.findBy(no);
    if (platform == null) {
      throw new Exception("플랫폼 번호가 유효하지 않습니다.");
    }
    map.put("platform", platform);
    return "/platform/view.jsp";
  }

  @RequestMapping("/platform/update")
  public String update(Platform platform) throws Exception {
    Platform old = platformDao.findBy(platform.getNo());
    if (old == null) {
      throw new Exception("플랫폼 번호가 유효하지 않습니다.");
    }
    platformDao.update(platform);
    return "redirect:list";
  }

  @RequestMapping("/platform/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (platformDao.delete(no) == 0) {
      throw new Exception("플랫폼 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}

