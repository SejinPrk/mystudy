package myapp.handler.member;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MemberDao;
import book.myapp.vo.Member;
import book.util.Prompt;
import java.util.List;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-6s\t%-6s\t%-15s\t%s\n", "회원번호", "이름", "대출여부", "도서명", "반납(예정)일");

    List<Member> list = memberDao.findAll();

    for (Member member : list) {
      System.out.printf("%-6d\t%-7s\t%-6s\t%-15s\t%s\n",
          member.getNo(),
          member.getName(),
          member.getBorrow(),
          member.getBname(),
          member.getDeadline());
    }
  }
}

