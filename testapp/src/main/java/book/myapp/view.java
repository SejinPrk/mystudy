package book.myapp;

import book.menu.MenuGroup;
import book.myapp.dao.BooksDao;
import book.myapp.dao.MemberDao;
import book.myapp.dao.mysql.BooksDaoImpl;
import book.myapp.dao.mysql.MemberDaoImpl;
import book.myapp.handler.books.BooksAddHandler;
import book.myapp.handler.books.BooksDeleteHandler;
import book.myapp.handler.books.BooksListHandler;
import book.myapp.handler.books.BooksModifyHandler;
import book.myapp.handler.books.BooksViewHandler;
import book.myapp.handler.member.MemberAddHandler;
import book.myapp.handler.member.MemberDeleteHandler;
import book.myapp.handler.member.MemberListHandler;
import book.myapp.handler.member.MemberModifyHandler;
import book.myapp.handler.member.MemberViewHandler;
import book.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class view {

  Prompt prompt = new Prompt(System.in);

  BooksDao booksDao;
  MemberDao memberDao;
  MenuGroup mainMenu;

  view() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[도서관리 시스템]");
    new view().run();
  }

  void prepareDatabase() {
    try {
      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
//      Driver driver = new com.mysql.cj.jdbc.Driver();
//      DriverManager.registerDriver(driver);

      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
     //"jdbc:mysql://db-ld24q-kr.vpc-pub-cdb.ntruss.com/studydb","study", "Bitcamp!@#123");

      booksDao = new BooksDaoImpl(con);
      memberDao = new MemberDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup booksMenu = mainMenu.addGroup("도서 관리");
    booksMenu.addItem("도서 등록", new BooksAddHandler(booksDao, prompt));
    booksMenu.addItem("도서 조회", new BooksViewHandler(booksDao, prompt));
    booksMenu.addItem("도서 변경", new BooksModifyHandler(booksDao, prompt));
    booksMenu.addItem("도서 삭제", new BooksDeleteHandler(booksDao, prompt));
    booksMenu.addItem("도서 목록", new BooksListHandler(booksDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("회원 등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("회원 조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("회원 변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("회원 삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("회원 목록", new MemberListHandler(memberDao, prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }

}
