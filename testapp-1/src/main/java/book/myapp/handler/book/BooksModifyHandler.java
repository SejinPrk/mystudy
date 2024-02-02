package book.myapp.handler.book;

import book.menu.AbstractMenuHandler;
import book.myapp.dao.BookDao;
import book.myapp.vo.Book;
import book.util.Prompt;

public class BooksModifyHandler extends AbstractMenuHandler {

  private BookDao bookDao;

  public BooksModifyHandler(BookDao bookDao, Prompt prompt) {
    super(prompt);
    this.bookDao = bookDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      Book old = bookDao.findBy(no);
      if (old == null) {
        System.out.println("도서 번호가 유효하지 않습니다!");
        return;
      }

      Book book = new Book();
      book.setNo(old.getNo());
      book.setTitle(this.prompt.input("도서명(%s): ", old.getTitle()));
      book.setAuthor(this.prompt.input("저자(%s):  ", old.getAuthor()));
      book.setPublisher(this.prompt.input("출판사(%s): ", old.getPublisher()));
      book.setGenre(this.prompt.input("분류(%s): ", old.getGenre()));

      bookDao.update(book);
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
