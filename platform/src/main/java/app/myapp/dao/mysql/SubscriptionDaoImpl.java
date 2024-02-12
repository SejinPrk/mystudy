package app.myapp.dao.mysql;

import app.myapp.dao.DaoException;
import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.awt.SplashScreen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {

  Connection con;

  public SubscriptionDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Subscription subscription) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "insert into subscriptions(start, end) values(?,?)")) {
        pstmt.setDate(1, subscription.getStart());
        pstmt.setDate(2, subscription.getEnd());

        pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from subscriptions where platform_no=?")) {
      pstmt.setInt(1, no);
        return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Subscription> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select start, end from subscriptions");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Subscription> list = new ArrayList<>();

      while (rs.next()) {
        Subscription subscription = new Subscription();
        subscription.setStart(rs.getDate("start"));
        subscription.setEnd(rs.getDate("end"));

        list.add(subscription);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Subscription findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from subscriptions where start=?")){

      pstmt.setDate(1, );

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Subscription subscription = new Subscription();
          subscription.setStart(rs.getDate("start"));
          subscription.setEnd(rs.getDate("end"));
          return subscription;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
