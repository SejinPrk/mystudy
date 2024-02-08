package app.myapp.dao;

import app.myapp.vo.Payment;
import java.util.List;

public interface MethodDao {

  void add(Payment method);

  int delete(int no);

  List<Payment> findAll();

  Payment findBy(int no);

  int update(Payment method);

}
