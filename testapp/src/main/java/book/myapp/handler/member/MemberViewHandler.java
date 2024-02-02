package book.myapp.handler.member;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MemberDao;
import book.myapp.vo.Member;
import book.util.Prompt;
import com.sun.jdi.request.InvalidRequestStateException;

public class MemberViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberViewHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호? ");

    Member member = memberDao.findBy(no);
    if (member == null) {
      System.out.println("회원번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("회원번호: %d\n", member.getNo());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("대출여부: %s\n", member.getBorrow());
    System.out.printf("도서명: %s\n", member.getBname());
    System.out.printf("반납일: %s\n", member.getDeadline());
  }
}
