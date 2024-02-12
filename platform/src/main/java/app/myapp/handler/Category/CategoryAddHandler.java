package app.myapp.handler.Category;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.CategoryDao;
import app.myapp.vo.Category;
import app.util.Prompt;
import java.util.Date;

public class CategoryAddHandler extends AbstractMenuHandler {

  private CategoryDao categoryDao;

  public CategoryAddHandler(CategoryDao categoryDao, Prompt prompt) {
    super(prompt);
    this.categoryDao = categoryDao;
  }

  @Override
  protected void action() {
    Category category = new Category();
    category.setId(this.prompt.input("ID: "));
    member.setPassword(this.prompt.input("pw: "));
    member.setName(this.prompt.input("이름: "));
    member.setTel(this.prompt.input("전화번호: "));
    member.setEmail(this.prompt.input("이메일: "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
