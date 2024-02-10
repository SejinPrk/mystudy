package app.myapp.dao;

import app.myapp.vo.Payment;
import java.util.List;

public interface PaymentDao {

  void add(Payment payment);

  int delete(int no);

  List<Payment> findAll();

  Payment findBy(int no);

  int update(Payment payment);

}
