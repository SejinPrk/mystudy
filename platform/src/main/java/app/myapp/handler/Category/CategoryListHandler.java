package app.myapp.handler.Category;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import app.util.Prompt;
import java.util.List;

public class CategoryListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public CategoryListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%30s\t%30s\t%s\n", "id", "이름", "전화번호", "이메일", "가입일");

    List<Member> list = memberDao.findAll();

    for (Member member : list) {
      System.out.printf("%-4d\t%-10s\t%30s\t%30s\t%4$tY-%4$tm-%4$td\n",
          member.getId(),
          member.getName(),
          member.getTel(),
          member.getEmail(),
          member.getCreatedDate());
    }
  }
}