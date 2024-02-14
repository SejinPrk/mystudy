package bitcamp.util;

import java.sql.Connection;

public class TranscationManager {

  ConnectionPool connectionPool;

  public TranscationManager(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  public void startTransaction() throws Exception{
    ConnectionPool.getConnection().setAutoCommit(false);
  }
  public void commit(){

  }

  public void rollback(){

  }
}
