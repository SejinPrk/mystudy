package book.myapp.handler.member;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MemberDao;
import book.myapp.vo.Member;
import book.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호: ");

    Member old = memberDao.findBy(no);
    if (old == null) {
      System.out.println("회원번호가 유효하지 않습니다!");
      return;
    }

    Member member = new Member();
    member.setNo(old.getNo());
    member.setName(this.prompt.input("이름(%s): ", old.getName()));
    member.setBorrow(this.prompt.input("대출여부(Y/N): ", old.getBorrow()));
    member.setBname(this.prompt.input("도서명: ", old.getBname()));
    member.setDeadline(this.prompt.inputDate("반납일: ",old.getDeadline()));

    memberDao.update(member);
    System.out.println("회원을 변경했습니다.");
  }
}
