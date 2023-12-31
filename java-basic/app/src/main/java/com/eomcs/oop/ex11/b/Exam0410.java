//static nested class : import static 사용 전
package com.eomcs.oop.ex11.b;

import com.eomcs.oop.ex11.b.sub.M;

class D {
  static int v1;

  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }
}

public class Exam0410 {

  public static void main(String[] args) {
    // 같은 패키지 클래스
    D.v1 = 100;
    D.m1();
    D.X obj = new D.X();

    // 다른 패키지 M의 클래스
    // import 했기 때문에 경로를 전부 적어야 할 필요가 없음.
    M.v2 = 200;
    M.m2();
    M.Y obj2 = new M.Y();
  }

}
