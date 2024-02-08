package app.myapp.dao.mysql;

import app.myapp.dao.PlatformDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Platform;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlatformDaoImpl implements PlatformDao {

  Connection con;

  public PlatformDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Platform platform) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "insert into platforms(title,content,deadline) values(?,?,?)")) {
        pstmt.setString(1, platform.getTitle());
        pstmt.setString(2, platform.getContent());
        pstmt.setDate(3, platform.getDeadline());

        pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from platforms where assignment_no=?")) {
      pstmt.setInt(1, no);
        return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select assignment_no, title, deadline from assignments order by assignment_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Platform> list = new ArrayList<>();

      while (rs.next()) {
        Assignment assignment = new Assignment();
        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
        assignment.setDeadline(rs.getDate("deadline"));

        list.add(assignment);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from assignments where assignment_no=?")){

      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Assignment assignment = new Assignment();
          assignment.setNo(rs.getInt("assignment_no"));
          assignment.setTitle(rs.getString("title"));
          assignment.setContent(rs.getString("content"));
          assignment.setDeadline(rs.getDate("deadline"));
          return assignment;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "update assignments set title=?, content=?, deadline=? where assignment_no=?")) {
      pstmt.setString(1, assignment.getTitle());
      pstmt.setString(2, assignment.getContent());
      pstmt.setDate(3, assignment.getDeadline());
      pstmt.setInt(4, assignment.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}