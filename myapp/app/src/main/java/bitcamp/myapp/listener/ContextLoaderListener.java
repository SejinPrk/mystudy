package bitcamp.myapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  // 웹 애플리케이션이 사용할 자원을 준비하고 해제하는 역할
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹애플리케이션 자원 준비!");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("웹애플리케이션 자원 해제!");
  }
}
