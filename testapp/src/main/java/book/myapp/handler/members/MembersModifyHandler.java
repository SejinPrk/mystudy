package book.myapp.handler.members;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MembersDao;
import book.myapp.vo.Members;
import book.util.Prompt;

public class MembersModifyHandler extends AbstractMenuHandler {

  private MembersDao membersDao;

  public MembersModifyHandler(MembersDao membersDao, Prompt prompt) {
    super(prompt);
    this.membersDao = membersDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호: ");

    Members old = membersDao.findBy(no);
    if (old == null) {
      System.out.println("회원번호가 유효하지 않습니다!");
      return;
    }

    Members members = new Members();
    members.setNo(old.getNo());
    members.setName(this.prompt.input("이름(%s): ", old.getName()));
    members.setBorrow(this.prompt.input("대출여부(Y/N): ", old.getBorrow()));
    members.setBname(this.prompt.input("도서명: ", old.getBname()));
    members.setDeadline(this.prompt.inputDate("반납일: ",old.getDeadline()));

    membersDao.update(members);
    System.out.println("회원을 변경했습니다.");
  }
}
