package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;
// 7) 생성자 도입:
// - 인스턴스를 생성할 때 값을 초기화시키는 특별한 메서드

public class App {
  public static void main(String[] args) {

    // 1) Score 설계도(클래스 정의)에 따라 인스턴스 변수를 Heap 영역에 만든다.
    // 2) 생성자를 호출한다.
    //  - 생성자에 넘겨주는 아규먼트의 타입과 개수, 순서에 따라 호출할 생성자를 결정한다.
    //  - 만약 해당 아규먼트를 받을 수 있는 생성자가 없다면 컴파일 오류가 난다.

    Score s1 = new Score("홍길동", 100, 90, 95);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);

    s2.kor = 100;
    s2.compute();

    printScore(s1);
    printScore(s2);
    printScore(s3);
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}

