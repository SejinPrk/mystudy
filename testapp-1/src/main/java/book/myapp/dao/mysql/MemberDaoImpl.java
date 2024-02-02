package book.myapp.dao.mysql;

import book.myapp.dao.DaoException;
import book.myapp.dao.MemberDao;
import book.myapp.vo.Member;
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
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into member(name,borrow,bname,deadline) values('%s','%s','%s','%s')",
          member.getName(), member.getBorrow(), member.getBname(), member.getDeadline()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from member where member_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from member");

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setBorrow(rs.getString("borrow"));
        member.setBname(rs.getString("bname"));
        member.setDeadline(rs.getDate("deadline"));

        list.add(member);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from member where member_no = " + no);

      if (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setBorrow(rs.getString("borrow"));
        member.setBname(rs.getString("bname"));
        member.setDeadline(rs.getDate("deadline"));

        return member;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update member set name='%s', borrow='%s', bname='%s', deadline='%s' where member_no=%d",
         member.getName(), member.getBorrow(), member.getBname(), member.getDeadline(), member.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
