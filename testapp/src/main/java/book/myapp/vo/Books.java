package book.myapp.vo;

import java.io.Serializable;

public class Books implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no; // identify number
  private String title;
  private String author;
  private String publisher;


  @Override
  public String toString() {
    return "Books{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publisher='" + publisher +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() { return title; }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}
