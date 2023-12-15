// 오버라이딩(overriding) - 오버라이딩과 super 키워드
package com.eomcs.oop.ex06.c;

public class Exam0412 {

  static class A {
    void m() {
      System.out.println("A의 m()");
    }
  }

  static class A2 extends A {

    @Override
    void m() {
      System.out.println("A2의 m()");
    }

    void test() {
      this.m();
      super.m();
    }
  }

  static class A3 extends A2 {
    @Override
    void m() {
      System.out.println("A3의 m()");
    }
  }

  static class A4 extends A3 {
    @Override
    void m() {
      System.out.println("A3의 m()");
    }
  }
  public static void main(String[] args) {
    A4 obj = new A4();
    obj.test();  // A2의 test() 호출
  }
}








