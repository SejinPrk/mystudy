package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {

  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public List<Member> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from members");

      ArrayList<Member> list = new ArrayList<>();

      while(rs.next()){
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));

        list.add(member);
      }
      return list;
    } catch (Exception e) {
  }

  @Override
  public Member findBy(int no) {
    return null;
  }

  @Override
  public int update(Member member) {
    return 0;
  }
}
