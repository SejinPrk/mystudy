package book.myapp.handler.member;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MemberDao;
import book.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberDeleteHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호: ");
    if (memberDao.delete(no) == -1) {
      System.out.println("회원번호가 유효하지 않습니다!");
    } else {
      System.out.println("회원을 삭제했습니다.");
    }
  }
}
