package app.myapp.dao.mysql;

import app.myapp.dao.SubscriptionDao;
import app.myapp.vo.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDaoImpl implements SubscriptionDao {


  public SubscriptionDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Subscription subscription) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
          "insert into subscriptions(start, end) values(?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)) {
        pstmt.setDate(1, subscription.getStart());
        pstmt.setDate(2, subscription.getEnd());

        pstmt.executeUpdate();

      try (ResultSet keyRs = pstmt.getGeneratedKeys()) {
        keyRs.next();
        subscription.setNo(keyRs.getInt(1));
      }

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "delete from subscriptions where subscription_no=?")) {
      pstmt.setInt(1, no);
        return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Subscription> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select subscription_no, start, end from subscriptions order by subscription_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Subscription> list = new ArrayList<>();

      while (rs.next()) {
        Subscription subscription = new Subscription();
        subscription.setNo(rs.getInt("subscription_no"));
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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from subscriptions where subscription_no=?")){

      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Subscription subscription = new Subscription();
          subscription.setNo(rs.getInt("subscription_no"));
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

  @Override
  public int update(Subscription subscription) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
          "update subscriptions set start=?, end=? where subscription_no=?")) {
      pstmt.setDate(1, subscription.getStart());
      pstmt.setDate(2, subscription.getEnd());
      pstmt.setInt(3, subscription.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
