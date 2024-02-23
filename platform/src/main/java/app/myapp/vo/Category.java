package app.myapp.vo;
// 분류
import java.io.Serializable;

public class Category implements Serializable {
  private static final long serialVersionUID = 100L;
  private int no;
  private String name;

  @Override
  public String toString() {
    return "Category{" +
        "no=" + no +
        ", name='" + name + '\'' +
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
}
