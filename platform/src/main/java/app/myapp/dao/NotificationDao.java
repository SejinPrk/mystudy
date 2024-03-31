package app.myapp.dao;

import app.myapp.vo.Notification;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NotificationDao {

  void add(Notification notification);

  int delete(int no);

  List<Notification> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount
  );

  Notification findBy(int no);

  int update(Notification notification);

  int countAll();
}
