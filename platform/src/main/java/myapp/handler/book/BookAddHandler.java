package myapp.handler.book;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BookDao;
import book.myapp.vo.Book;
import book.util.Prompt;

public class BookAddHandler extends AbstractMenuHandler {

  private BookDao bookDao;


  public BookAddHandler(BookDao bookDao, Prompt prompt) {
    super(prompt);
    this.bookDao = bookDao;
  }

  @Override
  protected void action() {
    try {
      Book book = new Book();
      book.setTitle(this.prompt.input("도서명: "));
      book.setAuthor(this.prompt.input("저자: "));
      book.setPublisher(this.prompt.input("출판사: "));
      book.setGenre(this.prompt.input("분류: "));

      bookDao.add(book);

    } catch (Exception e) {
      System.out.println("오류 발생!");
      e.printStackTrace();
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
