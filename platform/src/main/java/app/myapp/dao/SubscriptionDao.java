package app.myapp.dao;

import app.myapp.vo.Subscription;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubscriptionDao {

  void add(Subscription subscription);

  int delete(int no);

  List<Subscription> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount
  );

  Subscription findBy(int no);

  int update(Subscription subscription);

  int countAll();
}
