package book.myapp.handler.books;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BooksDao;
import book.myapp.vo.Books;
import book.util.Prompt;
import java.util.List;

public class BooksListHandler extends AbstractMenuHandler {

  private BooksDao booksDao;

  public BooksListHandler(BooksDao booksDao, Prompt prompt) {
    super(prompt);
    this.booksDao = booksDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%-20s\t%s\n", "번호", "도서명", "저자", "출판사");

    List<Books> list = booksDao.findAll();

    for (Books books : list) {
      System.out.printf("%-4d\t%-20s\t%-20s\t%s\n",
          books.getNo(),
          books.getTitle(),
          books.getAuthor(),
          books.getPublisher());
    }
  }
}
