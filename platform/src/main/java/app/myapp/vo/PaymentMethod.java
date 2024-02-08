package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class PaymentMethod implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String ID;
  private String price;
  private Date date;
  private Date Prev;
  private Date Next;

  
  @Override
  public String toString() {
    return "Board{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", writer='" + writer + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
