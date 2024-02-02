package book.myapp.handler.member;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MemberDao;
import book.myapp.vo.Member;
import book.util.Prompt;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setName(this.prompt.input("이름: "));
    member.setBorrow(this.prompt.input("대출여부(Y/N): "));
    member.setBname(this.prompt.input("도서명: "));
    member.setDeadline(this.prompt.inputDate("반납일: "));

    memberDao.add(member);
  }
}
