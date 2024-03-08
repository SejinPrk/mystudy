package app.myapp.controller;

import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

  private SubscriptionDao subscriptionDao;

  public SubscriptionController(SubscriptionDao subscriptionDao) {
    System.out.println("SubscriptionController() 호출됨!");
    this.subscriptionDao = subscriptionDao;
  }

  @RequestMapping("/subscription/form")
  public String form() throws Exception {
    return "/subscription/form.jsp";
  }

  @RequestMapping("/subscription/add")
  public String add(Subscription subscription) throws Exception {
    System.out.println(subscription);
    subscriptionDao.add(subscription);
    return "redirect:list";
  }

  @RequestMapping("/subscription/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", subscriptionDao.findAll());
    return "/subscription/list.jsp";
  }
  @RequestMapping("/subscription/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Subscription subscription = subscriptionDao.findBy(no);
    if (subscription == null) {
      throw new Exception("구독 번호가 유효하지 않습니다.");
    }
    map.put("subscription", subscription);
    return "/subscription/view.jsp";
  }

  @RequestMapping("/subscription/update")
  public String update(Subscription subscription) throws Exception {
    Subscription old = subscriptionDao.findBy(subscription.getNo());
    if (old == null) {
      throw new Exception("구독 번호가 유효하지 않습니다.");
    }
    subscriptionDao.update(subscription);
    return "redirect:list";
  }

  @RequestMapping("/subscription/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (subscriptionDao.delete(no) == 0) {
      throw new Exception("구독 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}
