package app.myapp.dao;

import app.myapp.vo.Notification;
import java.util.List;

public interface NotificationDao {

  void add(Notification notification);

  int delete(int no);

  List<Notification> findAll();

  Notification findBy(int no);

  int update(Notification notification);

}
