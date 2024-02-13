package app.myapp.handler.Category;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import app.util.Prompt;


public class CategoryViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public CategoryViewHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Member member = memberDao.findBy(no);
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("번호: %d\n", member.getNo());
    System.out.printf("id: %s\n", member.getId());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("전화번호: %s\n", member.getTel());
    System.out.printf("이메일: %s\n", member.getEmail());

    System.out.printf("가입일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", member.getCreatedDate());
  }
}