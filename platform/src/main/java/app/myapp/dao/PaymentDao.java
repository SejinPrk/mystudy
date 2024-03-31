package app.myapp.dao;

import app.myapp.vo.Payment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

  void add(Payment payment);

  int delete(int no);

  List<Payment> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount
  );

  Payment findBy(int no);

  int update(Payment payment);

  int countAll();
}
