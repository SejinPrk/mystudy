package app.myapp.handler.member;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import app.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Member old = memberDao.findBy(no);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    Member member = new Member();
    member.setNo(old.getNo());
    member.setId(this.prompt.input("id(%s):", old.getId()));
    member.setName(this.prompt.input("이름(%s): ", old.getName()));
    member.setTel(this.prompt.input("전화번호(%s)", old.getTel()));
    member.setEmail(this.prompt.input("이메일(%s): ", old.getEmail()));
    member.setPassword(this.prompt.input("new pw: "));
    member.setCreatedDate(old.getCreatedDate());

    memberDao.update(member);
    System.out.println("회원을 변경했습니다.");
  }
}
