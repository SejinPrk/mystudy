package app.myapp.dao;

import app.myapp.vo.Subscription;
import app.myapp.vo.Subscription;
import java.util.List;

public interface SubscriptionDao {

  void add(Subscription subscription);

  int delete(int no);

  List<Subscription> findAll();

  Subscription findBy(int no);

  int update(Subscription subscription);

}
