package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ThreadConnection {
  // 개별 스레드용 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
  private String jdbcUrl;
  private String username;
  private String password;

  public ThreadConnection(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }
  public Connection get() throws SQLException {
    // 현재 스레드에 보관중인 Connection 객체를 꺼낸다.
    Connection con = connectionThreadLocal.get();

    if (con == null) {
      System.out.printf("%s: DB 커넥션 생성\n", Thread.currentThread().getName());
      // 없다면, 새로 만든다.
      con = DriverManager.getConnection(jdbcUrl, username, password);

      // 나중에 또 사용할 수 있도록 현재 스레드에 보관한다.
      connectionThreadLocal.set(con);
    }
    return con;
  }

  public void remove() {
    // 현재 스레드에 보관중인 Connection 객체를 제거한다.
    Connection con = connectionThreadLocal.get();

    if(con != null) {
      try{
        con.close();
      } catch (Exception e){}
      connectionThreadLocal.remove();
      System.out.printf("%s: DB 커넥션 제거\n", Thread.currentThread().getName());
    }
  }
}