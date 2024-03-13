package app.myapp.controller;

import app.myapp.dao.NotificationDao;
import app.myapp.vo.Notification;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationController {

  private NotificationDao notificationDao;

  public NotificationController(NotificationDao notificationDao) {
    System.out.println("NotificationController() 호출됨!");
    this.notificationDao = notificationDao;
  }

  @RequestMapping("/notification/form")
  public String form() throws Exception {
    return "/notification/form.jsp";
  }

  @RequestMapping("/notification/add")
  public String add(Notification notification) throws Exception {
    System.out.println(notification);
    notificationDao.add(notification);
    return "redirect:list";
  }

  @RequestMapping("/notification/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", notificationDao.findAll());
    return "/category/list.jsp";
  }
  @RequestMapping("/notification/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Notification notification = notificationDao.findBy(no);
    if (notification == null) {
      throw new Exception("알림 번호가 유효하지 않습니다.");
    }
    map.put("notification", notification);
    return "/notification/view.jsp";
  }

  @RequestMapping("/notification/update")
  public String update(Notification notification) throws Exception {
    Notification old = notificationDao.findBy(notification.getNo());
    if (old == null) {
      throw new Exception("알림 번호가 유효하지 않습니다.");
    }
    notificationDao.update(notification);
    return "redirect:list";
  }

  @RequestMapping("/notification/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (notificationDao.delete(no) == 0) {
      throw new Exception("알림 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}

