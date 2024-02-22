package app.myapp.listener;

import app.myapp.dao.CategoryDao;
import app.myapp.dao.NotificationDao;
import app.myapp.dao.mysql.CategoryDaoImpl;
import app.myapp.dao.mysql.MemberDaoImpl;
import app.myapp.dao.mysql.NotificationDaoImpl;
import app.myapp.dao.mysql.PaymentDaoImpl;
import app.myapp.dao.mysql.PlatformDaoImpl;
import app.myapp.dao.PaymentDao;
import app.myapp.dao.PlatformDao;
import app.myapp.dao.MemberDao;
import app.util.DBConnectionPool;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  // 웹애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹애플리케이션 자원 준비!");
    // DB 커넥션, DAO, 트랜잭션 관리자 생성
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

    PlatformDao platformDao = new PlatformDaoImpl(connectionPool);
    MemberDao memberDao = new MemberDaoImpl(connectionPool);
    NotificationDao notificationDao = new NotificationDaoImpl(connectionPool);
    PaymentDao paymentDao = new PaymentDaoImpl(connectionPool);
    CategoryDao categoryDao = new CategoryDaoImpl(connectionPool);

    // 서블릿에서 사용할 수 있도록 웹 애플리케이션 저장소에 보관한다.
    ServletContext 웹애플리케이션저장소 = sce.getServletContext();
    웹애플리케이션저장소.setAttribute("platformDao", platformDao);
    웹애플리케이션저장소.setAttribute("notificationDao", notificationDao);
    웹애플리케이션저장소.setAttribute("memberDao", memberDao);
    웹애플리케이션저장소.setAttribute("paymentDao", paymentDao);
    웹애플리케이션저장소.setAttribute("categoryDao", categoryDao);

  }
}
