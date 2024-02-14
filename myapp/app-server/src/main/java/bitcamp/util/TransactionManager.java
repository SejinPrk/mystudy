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
    connectionPool.getConnection().commit();
    close();
  }

  public void rollback() throws Exception {
    connectionPool.getConnection().rollback();
    close();
  }

  private void close() throws Exception {
    Connection con = connectionPool.getConnection();
    con.setAutoCommit(true);
    con.close();
  }
}
