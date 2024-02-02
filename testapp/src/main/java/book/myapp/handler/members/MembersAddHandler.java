package book.myapp.handler.members;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MembersDao;
import book.myapp.vo.Members;
import book.util.Prompt;

public class MembersAddHandler extends AbstractMenuHandler {

  private MembersDao membersDao;

  public MembersAddHandler(MembersDao membersDao, Prompt prompt) {
    super(prompt);
    this.membersDao = membersDao;
  }

  @Override
  protected void action() {
    Members members = new Members();
    members.setName(this.prompt.input("이름: "));
    members.setBorrow(this.prompt.input("대출여부(Y/N): "));
    members.setBname(this.prompt.input("도서명: "));
    members.setDeadline(this.prompt.inputDate("반납일: "));

    membersDao.add(members);
  }
}
