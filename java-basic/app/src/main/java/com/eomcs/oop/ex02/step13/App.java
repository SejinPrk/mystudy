package com.eomcs.oop.ex02.step13;

// 데이터 타입 정의
//0) 낱개 변수 사용
//1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
//2) 리펙토링:
//- 메서드 추출(extract method): 중복되는 코드가 있으면 별도의 메서드로 출력한다.

public class App {

  // 인스턴스 변수(instance variable; instance field)
  // - new 명령으로 생성되는 변수이다.
  // - 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  //

  public static void main(String[] args) {
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();

    // Heap 영역에 생성된 인스턴스의 변수는 레퍼런스를 통해 접근한다.
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;

    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;


    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;

    printScore(s1);
    printScore(s2);
    printScore(s3);

  }

  // 합계와 평균, 출력 코드를 분리하여 별도의 메서드로 정의한다.
  // 중복 코드 제거하여 메서드로 정의해두면 재사용하기가 쉽다.
  //
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    //s.aver = (float) s.sum / 3;
    s.aver = s.sum / 3f;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
