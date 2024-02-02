package book.myapp.handler.members;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MembersDao;
import book.util.Prompt;

public class MembersDeleteHandler extends AbstractMenuHandler {

  private MembersDao membersDao;

  public MembersDeleteHandler(MembersDao membersDao, Prompt prompt) {
    super(prompt);
    this.membersDao = membersDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호: ");
    if (membersDao.delete(no) == -1) {
      System.out.println("회원번호가 유효하지 않습니다!");
    } else {
      System.out.println("회원을 삭제했습니다.");
    }
  }
}
