package book.myapp.dao.mysql;

import book.myapp.dao.BookDao;
import book.myapp.dao.DaoException;
import book.myapp.vo.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

  Connection con;

  public BookDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Book book) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into book(title,author,publisher,genre) values('%s','%s','%s','%s')",
          book.getTitle(), book.getAuthor(), book.getPublisher(), book.getGenre()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from book where book_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Book> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from book");

      ArrayList<Book> list = new ArrayList<>();

      while (rs.next()) {
        Book book = new Book();
        book.setNo(rs.getInt("book_no"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setGenre(rs.getString("genre"));

        list.add(book);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Book findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from book where book_no=" + no);

      if (rs.next()) {
        Book book = new Book();
        book.setNo(rs.getInt("book_no"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setGenre(rs.getString("genre"));

        return book;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Book book) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update book set title='%s', author='%s', publisher='%s', genre='%s' where book_no=%d",
          book.getTitle(), book.getAuthor(), book.getPublisher(), book.getGenre(),
          book.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
