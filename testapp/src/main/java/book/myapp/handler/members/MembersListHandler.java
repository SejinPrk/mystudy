package book.myapp.handler.members;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MembersDao;
import book.myapp.vo.Members;
import book.util.Prompt;
import java.util.List;

public class MembersListHandler extends AbstractMenuHandler {

  private MembersDao membersDao;

  public MembersListHandler(MembersDao membersDao, Prompt prompt) {
    super(prompt);
    this.membersDao = membersDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-4s\t%-5s\t%-10s\t%s\n", "회원번호", "이름", "대출여부", "도서명", "반납일");

    List<Members> list = membersDao.findAll();

    for (Members members : list) {
      System.out.printf("%-5d\t%-7s\t%-6s\t%-10s\t%s\n",
          members.getNo(),
          members.getName(),
          members.getBorrow(),
          members.getBname(),
          members.getDeadline());
    }
  }
}
