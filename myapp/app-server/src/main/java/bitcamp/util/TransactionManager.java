package bitcamp.util;

import java.sql.Connection;

public class TransactionManager {

  ConnectionPool connectionPool;

  public TransactionManager(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  public void startTransaction() throws Exception {
    connectionPool.getConnection().setAutoCommit(false);
  }
  public void commit() throws Exception {
    Connection con = connectionPool.getConnection();
    con.commit();
    con.setAutoCommit(true);
    con.close();
  }

  public void rollback() throws Exception {
    Connection con = connectionPool.getConnection();
    con.rollback();
    con.setAutoCommit(true);
    con.close();
  }
}
