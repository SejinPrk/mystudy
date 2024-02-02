package book.myapp.dao;

import book.myapp.vo.Book;
import java.util.List;

public interface BookDao {

  void add(Book book);

  int delete(int no);

  List<Book> findAll();

  Book findBy(int no);

  int update(Book book);

}
