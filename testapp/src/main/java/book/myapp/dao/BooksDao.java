package book.myapp.dao;

import book.myapp.vo.Books;
import java.util.List;

public interface BooksDao {

  void add(Books books);

  int delete(int no);

  List<Books> findAll();

  Books findBy(int no);

  int update(Books books);

}
