package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private int futurePay;
  private int time;
  private int fixedCost;
  private String cancellation;
  private int rate;
  
  @Override
  public String toString() {
    return "Report{" +
        "no=" + no +
        ", futurePay='" + futurePay + '\'' +
        ", time='" + time + '\'' +
        ", fixedCost='" + fixedCost + '\'' +
        ", cancellation=" + cancellation + '\'' +
        ", rate=" + rate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getFuturePay() {
    return futurePay;
  }

  public void setFuturePay(int futurePay) {
    this.futurePay = futurePay;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getFixedCost() {
    return fixedCost;
  }

  public void setFixedCost(int fixedCost) {
    this.fixedCost = fixedCost;
  }

  public String getCancellation() {
    return cancellation;
  }

  public void setCancellation(String cancellation) {
    this.cancellation = cancellation;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }
}
