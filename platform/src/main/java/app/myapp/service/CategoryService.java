package app.myapp.service;

import app.myapp.vo.Category;
import java.util.List;

public interface CategoryService {
  void add(Category category);

  List<Category> list(int pageNo, int pageSize);

  Category get(int no);

  int update(Category category);

  int delete(int no);

  int countAll();
}