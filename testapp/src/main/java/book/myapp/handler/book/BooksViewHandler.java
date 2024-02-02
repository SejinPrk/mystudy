package book.myapp.handler.book;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BookDao;
import book.myapp.vo.Book;
import book.util.Prompt;

public class BooksViewHandler extends AbstractMenuHandler {

  private BookDao bookDao;

  public BooksViewHandler(BookDao bookDao, Prompt prompt) {
    super(prompt);
    this.bookDao = bookDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      Book book = bookDao.findBy(no);
      if (book == null) {
        System.out.println("도서 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", book.getNo());
      System.out.printf("도서명: %s\n", book.getTitle());
      System.out.printf("저자: %s\n", book.getAuthor());
      System.out.printf("출판사: %s\n", book.getPublisher());
      System.out.printf("분류: %s\n", book.getGenre());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
