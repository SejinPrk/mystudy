package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String content;
  private Date date;
  private boolean check;

  @Override
  public String toString() {
    return "Notification{" +
        "no=" + no +
        ", content='" + content + '\'' +
        ", date='" + date + '\'' +
        ", check='" + check +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public java.sql.Date getDate() {
    return (java.sql.Date) date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isCheck() {
    return check;
  }

  public void setCheck(boolean check) {
    this.check = check;
  }
}
