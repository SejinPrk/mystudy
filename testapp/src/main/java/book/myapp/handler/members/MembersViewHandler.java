package book.myapp.handler.members;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.MembersDao;
import book.myapp.vo.Members;
import book.util.Prompt;

public class MembersViewHandler extends AbstractMenuHandler {

  private MembersDao membersDao;

  public MembersViewHandler(MembersDao membersDao, Prompt prompt) {
    super(prompt);
    this.membersDao = membersDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("회원번호: ");

    Members members = membersDao.findBy(no);
    if (members == null) {
      System.out.println("회원번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("회원번호: %d\n", members.getNo());
    System.out.printf("이름: %s\n", members.getName());
    System.out.printf("대출여부: %s\n", members.getBorrow());
    System.out.printf("도서명: %s\n", members.getBname());
    System.out.printf("반납일: %s\n", members.getDeadline());
  }
}
