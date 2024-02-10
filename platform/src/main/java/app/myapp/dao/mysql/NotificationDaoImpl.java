package app.myapp.dao.mysql;

import app.myapp.dao.NotificationDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {

  int category;
  Connection con;

  public NotificationDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Notification notification) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into notifications(content,date,check) values(?,?,?)")) {

      pstmt.setString(1, notification.getContent());
      pstmt.setDate(2, notification.getDate());
      pstmt.setBoolean(3, notification.isCheck());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from notifications where notification_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Notification> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select notification_no, content, date, check"
            + " from notifications order by notification_no desc")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {

        ArrayList<Notification> list = new ArrayList<>();

        while (rs.next()) {
          Notification board = new Notification();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setWriter(rs.getString("writer"));
          board.setCreatedDate(rs.getDate("created_date"));

          list.add(board);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Notification findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement("select * from boards where board_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Notification board = new Notification();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          board.setWriter(rs.getString("writer"));
          board.setCreatedDate(rs.getDate("created_date"));

          return board;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Notification report) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update boards set title=?, content=?, writer=? where board_no=?")) {

      pstmt.setString(1, report.getTitle());
      pstmt.setString(2, report.getContent());
      pstmt.setString(3, report.getWriter());
      pstmt.setInt(4, report.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
