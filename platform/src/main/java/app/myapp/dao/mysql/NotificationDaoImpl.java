package app.myapp.dao.mysql;

import app.myapp.dao.NotificationDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Notification;
import app.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {

  DBConnectionPool connectionPool;

  public NotificationDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Notification notification) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into notifications(content,date,checked) values(?,?,?)")) {

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from notifications where notification_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Notification> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select notification_no, content, date, checked from notifications order by notification_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Notification> list = new ArrayList<>();

      while (rs.next()) {
        Notification notification = new Notification();
        notification.setNo(rs.getInt("notification_no"));
        notification.setContent(rs.getString("content"));
        notification.setDate(rs.getDate("date"));
        notification.setCheck(rs.getBoolean("checked"));

        list.add(notification);
      }
      return list;

  } catch(Exception e) {
    throw new DaoException("데이터 가져오기 오류", e);
  }
}

  @Override
  public Notification findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement
            ("select * from notifications where notification_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Notification notification = new Notification();
          notification.setNo(rs.getInt("notification_no"));
          notification.setContent(rs.getString("content"));
          notification.setDate(rs.getDate("date"));
          notification.setCheck(rs.getBoolean("checked"));
          return notification;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Notification notification) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "update notifications set content=?, date=?, checked=? where notification_no=?")) {

      pstmt.setString(1, notification.getContent());
      pstmt.setDate(2, notification.getDate());
      pstmt.setBoolean(3, notification.isCheck());
      pstmt.setInt(4, notification.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  // 회원 번호를 통해 회원 이름을 가져오는 메서드
  private static String getMemberName(int memberNo) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select name from members where member_no=?")) {
      pstmt.setString(1, name);
      pstmt.setInt(2, no);
    return name;
  }
}
