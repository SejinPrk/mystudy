package app.myapp.controller;

import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

  private PaymentDao paymentDao;

  public PaymentController(PaymentDao paymentDao) {
    System.out.println("PaymentController() 호출됨!");
    this.paymentDao = paymentDao;
  }

  @RequestMapping("/payment/form")
  public String form() throws Exception {
    return "/payment/form.jsp";
  }

  @RequestMapping("/payment/add")
  public String add(Payment payment) throws Exception {
    System.out.println(payment);
    paymentDao.add(payment);
    return "redirect:list";
  }

  @RequestMapping("/payment/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", paymentDao.findAll());
    return "/payment/list.jsp";
  }
  @RequestMapping("/payment/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Payment payment = paymentDao.findBy(no);
    if (payment== null) {
      throw new Exception("결제내역 번호가 유효하지 않습니다.");
    }
    map.put("payment", payment);
    return "/category/view.jsp";
  }

  @RequestMapping("/payment/update")
  public String update(Payment payment) throws Exception {
    Payment old = paymentDao.findBy(payment.getNo());
    if (old == null) {
      throw new Exception("결제내역 번호가 유효하지 않습니다.");
    }
    paymentDao.update(payment);
    return "redirect:list";
  }

  @RequestMapping("/payment/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (paymentDao.delete(no) == 0) {
      throw new Exception("결제내역 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}

