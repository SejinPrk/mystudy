package app.myapp.dao;

import app.myapp.vo.Platform;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlatformDao {

  void add(Platform platform);

  int delete(int no);

  List<Platform> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount
  );

  Platform findBy(int no);

  int update(Platform platform);

  int countAll();
}
