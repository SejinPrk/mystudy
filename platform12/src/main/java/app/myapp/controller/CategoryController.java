package app.myapp.controller;

import app.myapp.dao.CategoryDao;
import app.myapp.vo.Category;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

  private CategoryDao categoryDao;

  public CategoryController(CategoryDao categoryDao) {
    System.out.println("CategoryController() 호출됨!");
    this.categoryDao = categoryDao;
  }

  @RequestMapping("/category/form")
  public String form() throws Exception {
    return "/category/form.jsp";
  }

  @RequestMapping("/category/add")
  public String add(Category category) throws Exception {
    System.out.println(category);
    categoryDao.add(category);
    return "redirect:list";
  }

  @RequestMapping("/category/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", categoryDao.findAll());
    return "/category/list.jsp";
  }
  @RequestMapping("/category/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Category category = categoryDao.findBy(no);
    if (category== null) {
      throw new Exception("분류 번호가 유효하지 않습니다.");
    }
    map.put("category", category);
    return "/category/view.jsp";
  }

  @RequestMapping("/category/update")
  public String update(Category category) throws Exception {
    Category old = categoryDao.findBy(category.getNo());
    if (old == null) {
      throw new Exception("분류 번호가 유효하지 않습니다.");
    }
    categoryDao.update(category);
    return "redirect:list";
  }

  @RequestMapping("/category/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    if (categoryDao.delete(no) == 0) {
      throw new Exception("분류 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}

