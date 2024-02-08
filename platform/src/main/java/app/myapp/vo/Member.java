package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String id;
  private String password;
  private String name;
  private String tel;
  private String email;
  private Date createdDate;
  private int creditNo;
  private boolean notification;


  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        "id=" + id + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", tel='" + tel + '\'' +
        ", email='" + email + '\'' +
        ", createdDate=" + createdDate + '\'' +
        ", creditNo=" + creditNo + '\'' +
        ", notification=" + notification +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreatedDate() {
    return createdDate;
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

  public boolean isNotification() {
    return notification;
  }

  public void setNotification(boolean notification) {
    this.notification = notification;
  }
}
