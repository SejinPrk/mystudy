package book.myapp.handler.books;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BooksDao;
import book.myapp.vo.Books;
import book.util.Prompt;

public class BooksAddHandler extends AbstractMenuHandler {

  private BooksDao booksDao;


  public BooksAddHandler(BooksDao booksDao, Prompt prompt) {
    super(prompt);
    this.booksDao = booksDao;
  }

  @Override
  protected void action() {
    try {
      Books books = new Books();
      books.setTitle(this.prompt.input("도서명: "));
      books.setAuthor(this.prompt.input("저자: "));
      books.setPublisher(this.prompt.input("출판사: "));

      booksDao.add(books);

    } catch (Exception e) {
      System.out.println("오류 발생!");
      e.printStackTrace();
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
