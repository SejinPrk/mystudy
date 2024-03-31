package app.myapp.dao;

import app.myapp.vo.Category;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryDao {
  void add(Category category);

  int delete(int no);

  List<Category> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount);

  Category findBy(int no);

  int update(Category category);

  int countAll();
}
