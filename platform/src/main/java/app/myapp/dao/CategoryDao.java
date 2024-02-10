package app.myapp.dao;

import app.myapp.vo.Category;
import java.util.List;

public interface CategoryDao {

  public void add(Category category);

  public int delete(int no);

  public List<Category> findAll();

  public Category findBy(int no);

  public int update(Category category);

  ;
}
