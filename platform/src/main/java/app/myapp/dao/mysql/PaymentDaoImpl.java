package app.myapp.dao.mysql;

import app.myapp.dao.DaoException;
import app.myapp.dao.PaymentDao;
import app.myapp.vo.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

  Connection con;

  public PaymentDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Payment payment) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "insert into payments(start,end,amount) values(?,?,?)")){
      pstmt.setDate(1, payment.getStart());
      pstmt.setDate(2, payment.getEnd());
      pstmt.setInt(3, payment.getAmount());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from payments where payment_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Payment> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select payment_no, start, end, amount from payments");
      ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Payment> list = new ArrayList<>();

      while (rs.next()) {
        Payment payment = new Payment();
        payment.setNo(rs.getInt("payment_no"));
        payment.setStart(rs.getDate("start"));
        payment.setEnd(rs.getDate("end"));
        payment.setAmount(rs.getInt("amount"));

        list.add(payment);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Payment findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select payment_no, start, end, amount from payments where payment_no=?")){
      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Payment payment = new Payment();
          payment.setNo(rs.getInt("payment_no"));
          payment.setStart(rs.getDate("start"));
          payment.setEnd(rs.getDate("end"));
          payment.setAmount(rs.getInt("amount"));
          return payment;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Payment payment) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update payments set start=?, end=?, amount=? where payment_no=?")){
      pstmt.setDate(1, payment.getStart());
      pstmt.setDate(2, payment.getEnd());
      pstmt.setInt(3, payment.getAmount());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
