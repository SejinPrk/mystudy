package book.myapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class Members implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String name;
  private String borrow;
  private String bname;
  private Date deadline;

  @Override
  public String toString() {
    return "Members{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", borrow='" + borrow + '\'' +
        ", bname='" + bname + '\'' +
        ", deadline=" + deadline +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBorrow() {
    return borrow;
  }

  public void setBorrow(String borrow) {
    this.borrow = borrow;
  }
  public String getBname() { return bname; }

  public void setBname(String bname) { this.bname = bname; }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
}
