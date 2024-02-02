package book.myapp.handler.books;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BooksDao;
import book.myapp.vo.Books;
import book.util.Prompt;

public class BooksViewHandler extends AbstractMenuHandler {

  private BooksDao booksDao;

  public BooksViewHandler(BooksDao booksDao, Prompt prompt) {
    super(prompt);
    this.booksDao = booksDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호: ");
      Books books = booksDao.findBy(no);
      if (books == null) {
        System.out.println("도서 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", books.getNo());
      System.out.printf("도서명: %s\n", books.getTitle());
      System.out.printf("저자: %s\n", books.getAuthor());
      System.out.printf("출판사: %s\n", books.getPublisher());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
