package book.myapp.dao.mysql;

import book.myapp.dao.DaoException;
import book.myapp.dao.MembersDao;
import book.myapp.vo.Members;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembersDaoImpl implements MembersDao {

  Connection con;

  public MembersDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Members members) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into members(name,borrow,bname,deadline) values('%s','%s','%s','%s')",
          members.getName(), members.getBorrow(), members.getBname(), members.getDeadline()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from members where member_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Members> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from members");

      ArrayList<Members> list = new ArrayList<>();

      while (rs.next()) {
        Members members = new Members();
        members.setNo(rs.getInt("member_no"));
        members.setName(rs.getString("name"));
        members.setBorrow(rs.getString("borrow"));
        members.setBname(rs.getString("bname"));
        members.setDeadline(rs.getDate("deadline"));

        list.add(members);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Members findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from members where member_no = " + no);

      if (rs.next()) {
        Members members = new Members();
        members.setNo(rs.getInt("member_no"));
        members.setBorrow(rs.getString("borrow"));
        members.setDeadline(rs.getDate("deadline"));

        return members;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Members members) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update members set name='%s', borrow='%s', bname='%s', deadline='%s' where member_no=%d",
         members.getName(), members.getBorrow(), members.getBname(), members.getDeadline(), members.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
