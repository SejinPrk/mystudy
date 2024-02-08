package app.myapp.vo;

import java.io.Serializable;

public class Method implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String method;
  private String info;

  
  @Override
  public String toString() {
    return "Method{" +
        "no=" + no +
        ", method='" + method + '\'' +
        ", info='" + info +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
