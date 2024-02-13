package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ThreadConnection {
  // 개별 스레드용 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
  String jdbcUrl;
  String username;
  String password;

  public ThreadConnection(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }
  public Connection get() throws SQLException {
    // 현재 스레드에 보관중인 Connection 객체를 꺼낸다.
    Connection con = connectionThreadLocal.get();

    if (con == null) {
      // 없다면, 새로 만든다.
      con = DriverManager.getConnection(jdbcUrl, username, password);

      // 나중에 또 사용할 수 있도록 현재 스레드에 보관한다.
      connectionThreadLocal.set(con);
    }
    return con;
  }

  public void remove(Connection con) {
    
  }
}
