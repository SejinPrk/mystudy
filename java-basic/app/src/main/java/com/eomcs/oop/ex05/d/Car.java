package com.eomcs.oop.ex05.d;

public class Car {
  // 실제 상속에서는 기존 코드가 필요없다.
  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


