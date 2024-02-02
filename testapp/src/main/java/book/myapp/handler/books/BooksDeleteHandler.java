package book.myapp.handler.books;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BooksDao;
import book.util.Prompt;

public class BooksDeleteHandler extends AbstractMenuHandler {

  private BooksDao booksDao;

  public BooksDeleteHandler(BooksDao booksDao, Prompt prompt) {
    super(prompt);
    this.booksDao = booksDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      if (booksDao.delete(no) == 0) {
        System.out.println("도서 번호가 유효하지 않습니다!");
      } else {
        System.out.println("도서를 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}
