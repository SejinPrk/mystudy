package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {
  private DBConnectionPool connectionPool;
  private MemberDao memberDao;

  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Member member = new Member();
    member.setEmail(prompt.input("이메일? "));
    member.setName(prompt.input("이름? "));
    member.setPassword(prompt.input("암호? "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
