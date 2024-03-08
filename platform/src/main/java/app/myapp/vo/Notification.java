package app.myapp.vo;
// 알림
import java.io.Serializable;
import java.sql.Date;

public class Notification implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String content;
  private Date date;
  private boolean checked;

  @Override
  public String toString() {
    return "Notification{" +
        "no=" + no +
        ", content='" + content + '\'' +
        ", date='" + date + '\'' +
        ", check='" + checked +
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

  public Date getDate() { return date;}

  public void setDate(Date date) {this.date = date;}

  public boolean isCheck() {
    return checked;
  }

  public void setCheck(boolean check) {
    this.checked = check;
  }
}
