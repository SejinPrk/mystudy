package app.myapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class Platform implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String name;
  private int price;
  private String option;
  private String term;


  @Override
  public String toString() {
    return "Platform{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", option=" + option + '\'' +
        ", term=" + term +
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getOption() {
    return option;
  }

  public void setOption(String option) {
    this.option = option;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }
}
