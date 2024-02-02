package book.myapp.handler.book;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BookDao;
import book.util.Prompt;

public class BookDeleteHandler extends AbstractMenuHandler {

  private BookDao bookDao;

  public BookDeleteHandler(BookDao bookDao, Prompt prompt) {
    super(prompt);
    this.bookDao = bookDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      if (bookDao.delete(no) == 0) {
        System.out.println("도서 번호가 유효하지 않습니다!");
      } else {
        System.out.println("도서를 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}
