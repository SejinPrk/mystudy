package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private Date start;
  private Date end;
  private int amount;

  
  @Override
  public String toString() {
    return "Payment{" +
        "no=" + no +
        ", start='" + start + '\'' +
        ", end='" + end + '\'' +
        ", amount=" + amount +
         '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public java.sql.Date getStart() {
    return (java.sql.Date) start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public java.sql.Date getEnd() {
    return (java.sql.Date) end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
