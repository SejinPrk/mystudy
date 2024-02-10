package app.myapp.handler.Category;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import app.util.Prompt;
import java.util.Date;

public class CategoryAddHandler extends AbstractMenuHandler {

  private CategoryDao memberDao;

  public CategoryAddHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setId(this.prompt.input("ID: "));
    member.setPassword(this.prompt.input("pw: "));
    member.setName(this.prompt.input("이름: "));
    member.setTel(this.prompt.input("전화번호: "));
    member.setEmail(this.prompt.input("이메일: "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
