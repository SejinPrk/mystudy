package book.myapp;

import book.menu.MenuGroup;
import book.myapp.dao.BookDao;
import book.myapp.dao.MemberDao;
import book.myapp.dao.mysql.BookDaoImpl;
import book.myapp.dao.mysql.MemberDaoImpl;
import book.myapp.handler.book.BookAddHandler;
import book.myapp.handler.book.BookDeleteHandler;
import book.myapp.handler.book.BookListHandler;
import book.myapp.handler.book.BooksModifyHandler;
import book.myapp.handler.book.BooksViewHandler;
import book.myapp.handler.member.MemberAddHandler;
import book.myapp.handler.member.MemberDeleteHandler;
import book.myapp.handler.member.MemberListHandler;
import book.myapp.handler.member.MemberModifyHandler;
import book.myapp.handler.member.MemberViewHandler;
import book.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class View {

  Prompt prompt = new Prompt(System.in);

  BookDao bookDao;
  MemberDao memberDao;
  MenuGroup mainMenu;

  View() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[도서관리시스템]");
    new View().run();
  }

  void prepareDatabase() {
    try {
      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
//      Driver driver = new com.mysql.cj.jdbc.Driver();
//      DriverManager.registerDriver(driver);

      Connection con = DriverManager.getConnection(
          //"jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
     "jdbc:mysql://db-ld24q-kr.vpc-pub-cdb.ntruss.com/studydb","study", "Bitcamp!@#123");

      bookDao = new BookDaoImpl(con);
      memberDao = new MemberDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup bookMenu = mainMenu.addGroup("도서 관리");
    bookMenu.addItem("도서 등록", new BookAddHandler(bookDao, prompt));
    bookMenu.addItem("도서 조회", new BooksViewHandler(bookDao, prompt));
    bookMenu.addItem("도서 변경", new BooksModifyHandler(bookDao, prompt));
    bookMenu.addItem("도서 삭제", new BookDeleteHandler(bookDao, prompt));
    bookMenu.addItem("도서 목록", new BookListHandler(bookDao, prompt));

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
