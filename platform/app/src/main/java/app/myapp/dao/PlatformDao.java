package app.myapp.dao;

import app.myapp.vo.Platform;
import java.util.List;

public interface PlatformDao {

  void add(Platform platform);

  int delete(int no);

  List<Platform> findAll();

  Platform findBy(int no);

  int update(Platform platform);

}
