package book.myapp.handler.book;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BookDao;
import book.myapp.vo.Book;
import book.util.Prompt;
import java.util.List;

public class BookListHandler extends AbstractMenuHandler {

  private BookDao bookDao;

  public BookListHandler(BookDao bookDao, Prompt prompt) {
    super(prompt);
    this.bookDao = bookDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-13s\t%-13s\t%-10s\t%3s\n", "번호", "도서명", "저자", "출판사", "분류");

    List<Book> list = bookDao.findAll();

    for (Book book : list) {
      System.out.printf("%-4d\t%-13s\t%-13s\t%-10s\t%3s\n",
          book.getNo(),
          book.getTitle(),
          book.getAuthor(),
          book.getPublisher(),
          book.getGenre());
    }
  }
}
