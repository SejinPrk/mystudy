package app.myapp.vo;
// 회원
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String password;
  private String name;
  private String tel;
  private String email;
  private Date createdDate;
  private int creditNo;
  private String creditDate;
  private boolean notification;


  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", createdDate=" + createdDate + '\'' +
        ", tel='" + tel + '\'' +
        ", creditNo=" + creditNo + '\'' +
        ", creditDate=" + creditDate + '\'' +
        ", notification=" + notification +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public java.sql.Date getCreatedDate() {
    return (java.sql.Date) createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getCreditNo() {
    return creditNo;
  }

  public void setCreditNo(int creditNo) {
    this.creditNo = creditNo;
  }

  public String getCreditDate() {
    return creditDate;
  }

  public void setCreditDate(String creditDate) {
    this.creditDate = creditDate;
  }

  public boolean isNotification() {
    return notification;
  }

  public void setNotification(boolean notification) {
    this.notification = notification;
  }
}
