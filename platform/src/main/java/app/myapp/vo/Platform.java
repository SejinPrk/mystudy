package app.myapp.vo;
// 플랫폼
import java.io.Serializable;

public class Platform implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String category;
  private String name;
  private int price;
  private String term;


  @Override
  public String toString() {
    return "Platform{" +
        "category=" + category +
        ", no=" + no +
        ", name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", term=" + term +
        '}';
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }
}
