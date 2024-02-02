package book.myapp.handler.books;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BooksDao;
import book.myapp.vo.Books;
import book.util.Prompt;

public class BooksModifyHandler extends AbstractMenuHandler {

  private BooksDao booksDao;

  public BooksModifyHandler(BooksDao booksDao, Prompt prompt) {
    super(prompt);
    this.booksDao = booksDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      Books old = booksDao.findBy(no);
      if (old == null) {
        System.out.println("도서 번호가 유효하지 않습니다!");
        return;
      }

      Books books = new Books();
      books.setNo(old.getNo());
      books.setTitle(this.prompt.input("도서명(%s): ", old.getTitle()));
      books.setAuthor(this.prompt.input("저자(%s):  ", old.getAuthor()));
      books.setPublisher(this.prompt.input("출판사(%s): ", old.getPublisher()));

      booksDao.update(books);
      System.out.println("도서를 변경했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("도서 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
      e.printStackTrace();
    }

  }
}
