package app.myapp;

import app.menu.MenuGroup;
import app.myapp.dao.PaymentDao;
import app.myapp.dao.PlatformDao;
import app.myapp.dao.NotificationDao;
import app.myapp.dao.MemberDao;
import app.myapp.dao.mysql.PaymentDaoImpl;
import app.myapp.dao.mysql.PlatformDaoImpl;
import app.myapp.dao.mysql.NotificationDaoImpl;
import app.myapp.dao.mysql.MemberDaoImpl;
import app.myapp.handler.payment.PaymentAddHandler;
import app.myapp.handler.payment.PaymentDeleteHandler;
import app.myapp.handler.payment.PaymentListHandler;
import app.myapp.handler.payment.PaymentModifyHandler;
import app.myapp.handler.payment.PaymentViewHandler;
import app.myapp.handler.platform.PlatformAddHandler;
import app.myapp.handler.platform.PlatformDeleteHandler;
import app.myapp.handler.platform.PlatformListHandler;
import app.myapp.handler.platform.PlatformModifyHandler;
import app.myapp.handler.platform.PlatformViewHandler;
import app.myapp.handler.subscription.SubscriptionListHandler;
import app.myapp.handler.subscription.SubscriptionViewHandler;
import app.myapp.handler.member.MemberAddHandler;
import app.myapp.handler.member.MemberDeleteHandler;
import app.myapp.handler.member.MemberListHandler;
import app.myapp.handler.member.MemberModifyHandler;
import app.myapp.handler.member.MemberViewHandler;
import app.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

  Prompt prompt = new Prompt(System.in);

  NotificationDao reportDao;
  PlatformDao platformDao;
  MemberDao memberDao;
  PaymentDao paymentDao;

  MenuGroup mainMenu;

  Main() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[플랫폼 관리 시스템]");
    new Main().run();
  }

  void prepareDatabase() {
    try {

      Connection con = DriverManager.getConnection(
         // "jdbc:mysql://localhost/studydb", "study", "app!@#123"
     "jdbc:mysql://db-ld24q-kr.vpc-pub-cdb.ntruss.com/studydb","study", "app!@#123");

      notificationDao = new NotificationDaoImpl(con);
      platformDao = new PlatformDaoImpl(con);
      memberDao = new MemberDaoImpl(con);
      paymentDao = new PaymentDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup platformMenu = mainMenu.addGroup("플랫폼");
    platformMenu.addItem("등록", new PlatformAddHandler(platformDao, prompt));
    platformMenu.addItem("조회", new PlatformViewHandler(platformDao, prompt));
    platformMenu.addItem("변경", new PlatformModifyHandler(platformDao, prompt));
    platformMenu.addItem("삭제", new PlatformDeleteHandler(platformDao, prompt));
    platformMenu.addItem("목록", new PlatformListHandler(platformDao, prompt));

    MenuGroup paymentMenu = mainMenu.addGroup("결제내역");
    paymentMenu.addItem("등록", new PaymentAddHandler(paymentDao, prompt));
    paymentMenu.addItem("조회", new PaymentViewHandler(paymentDao, prompt));
    paymentMenu.addItem("변경", new PaymentModifyHandler(paymentDao, prompt));
    paymentMenu.addItem("삭제", new PaymentDeleteHandler(paymentDao, prompt));
    paymentMenu.addItem("목록", new PaymentListHandler(paymentDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

    MenuGroup subscriptionMenu = mainMenu.addGroup("구독플랫폼");
    subscriptionMenu.addItem("조회", new SubscriptionViewHandler(subscriptionDao, prompt));
    subscriptionMenu.addItem("목록", new SubscriptionListHandler(subscriptionDao, prompt));
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
