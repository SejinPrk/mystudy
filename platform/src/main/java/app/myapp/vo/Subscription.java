package app.myapp.vo;
// 구독내역
import java.io.Serializable;
import java.sql.Date;

public class Subscription implements Serializable {

  private static final long serialVersionUID = 100L;

  private Date start;
  private Date end;

  @Override
  public String toString() {
    return "Subscription{" +
        "start=" + start +
        "end=" + end +
        '}';
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }
}
