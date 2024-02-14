package bitcamp.util;

public class TranscationManager {
  ConnectionPool connectionPool;

  public TranscationManager(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  public void commit(){

  }

  public void rollback(){
    
  }
}
