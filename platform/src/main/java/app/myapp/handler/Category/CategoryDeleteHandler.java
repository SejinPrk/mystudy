package app.myapp.handler.Category;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.MemberDao;
import app.util.Prompt;

public class CategoryDeleteHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public CategoryDeleteHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (memberDao.delete(no) == -1) {
      System.out.println("회원 번호가 유효하지 않습니다!");
    } else {
      System.out.println("회원을 삭제했습니다.");
    }
  }
}
