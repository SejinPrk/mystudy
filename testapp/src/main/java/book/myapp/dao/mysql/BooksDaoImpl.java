package book.myapp.dao.mysql;

import book.myapp.dao.BooksDao;
import book.myapp.dao.DaoException;
import book.myapp.vo.Books;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BooksDao {

  Connection con;

  public BooksDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Books books) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into books(title,author,publisher) values('%s','%s','%s')",
          books.getTitle(), books.getAuthor(), books.getPublisher()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from books where book_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Books> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from books");

      ArrayList<Books> list = new ArrayList<>();

      while (rs.next()) {
        Books books = new Books();
        books.setNo(rs.getInt("book_no"));
        books.setTitle(rs.getString("title"));
        books.setAuthor(rs.getString("author"));
        books.setPublisher(rs.getString("publisher"));

        list.add(books);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Books findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from books where book_no=" + no);

      if (rs.next()) {
        Books books = new Books();
        books.setNo(rs.getInt("book_no"));
        books.setTitle(rs.getString("title"));
        books.setAuthor(rs.getString("author"));
        books.setPublisher(rs.getString("publisher"));

        return books;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Books books) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update books set title='%s', author='%s', publisher='%s' where book_no=%d",
          books.getTitle(), books.getAuthor(), books.getPublisher(),
          books.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
