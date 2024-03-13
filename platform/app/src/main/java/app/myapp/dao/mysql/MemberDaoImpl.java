package app.myapp.dao.mysql;

import app.myapp.dao.DaoException;
import app.myapp.dao.MemberDao;
import app.myapp.vo.Member;
import app.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImpl implements MemberDao{

 DBConnectionPool connectionPool;

  public MemberDaoImpl(DBConnectionPool connectionPool) { this.connectionPool = connectionPool;}

  @Override
  public void add(Member member) {
      try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into members(email,name,password,photo,tel,credit_no,credit_date,notification)"
                + " values(?,?,sha2(?,256),?,?,?,?,?)")) {
        pstmt.setString(1, member.getEmail());
        pstmt.setString(2, member.getName());
        pstmt.setString(3, member.getPassword());
        pstmt.setString(4, member.getPhoto());
        pstmt.setString(5, member.getTel());
        pstmt.setInt(6, member.getCreditNo());
        pstmt.setString(7, member.getCreditDate());
        pstmt.setBoolean(8, member.isNotification());
        pstmt.executeUpdate();

      } catch (Exception e) {
        throw new DaoException("데이터 입력 오류", e);
      }
    }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from members where member_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select member_no, email, name, photo, tel, created_date, notification from members");
      ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setCreatedDate(rs.getDate("created_date"));
        member.setNotification(rs.getBoolean("notification"));

        list.add(member);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (Connection con = connectionPool.getConnection();
    PreparedStatement pstmt = con.prepareStatement(
        "select member_no,email,name,photo,tel,created_date,credit_no,credit_date,notification"
            + "from members where member_no=?")){
      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setEmail(rs.getString("email"));
          member.setName(rs.getString("name"));
          member.setPhoto(rs.getString("photo"));
          member.setTel(rs.getString("tel"));
          member.setCreatedDate(rs.getDate("created_date"));
          member.setCreditNo(rs.getInt("credit_no"));
          member.setCreditDate(rs.getString("credit_date"));
          member.setNotification(rs.getBoolean("notification"));
          return member;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Member member) {
  String sql = null;
    if (member.getPassword().length() == 0) {
      sql = "update members set email=?, name=?, photo=?, tel=?, credit_no=?, credit_date=?, notification=? "
          + "where member_no=?";
    } else {
      sql = "update members set email=?, name=?, photo=?, tel=?, credit_no=?, credit_date=?, notification=? "
          + "password=sha2(?,256), where member_no=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPhoto());
      pstmt.setString(4, member.getTel());
      pstmt.setInt(5, member.getCreditNo());
      pstmt.setString(6, member.getCreditDate());
      pstmt.setBoolean(7,member.isNotification());
      if (member.getPassword().length() == 0) {
        pstmt.setInt(8, member.getNo());
      } else {
        pstmt.setString(8, member.getPassword());
        pstmt.setInt(9, member.getNo());
      }
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
@Override
public Member findByEmailAndPassword(String email, String password) {
  try (Connection con = connectionPool.getConnection();
      PreparedStatement pstmt = con.prepareStatement(
          "select member_no, email, name, tel, created_date, from members where email=? and password=sha2(?,256)")) {
    pstmt.setString(1, email);
    pstmt.setString(2, password);

    try (ResultSet rs = pstmt.executeQuery()) {
      if (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setTel(rs.getString("tel"));
        member.setCreatedDate(rs.getDate("created_date"));
        return member;
      }
      return null;
    }

  } catch (Exception e) {
    throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
