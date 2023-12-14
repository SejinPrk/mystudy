// 생성자 활용 예 - java.util.Date 클래스의 생성자
package com.eomcs.oop.ex04;

import java.util.Date;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    // java.util.Date 클래스는 날짜 데이터를 다루는 클래스이다.
    // => 이 클래스에는 날짜 데이터를 다룰 수 있는 다양한 메서드가 들어 있다.

    // Date() 기본 생성자는 메모리를 오늘 날짜 값으로 초기화시킨다.
    Date d1 = new Date();
    System.out.println(d1);

    // 년, 월, 일 값으로 날짜 인스턴스를 초기화시킨다.
    Date d2 = new Date(122, 4, 3);
    // 년도를 지정할 때는 1900년도를 기준으로 해서 1900을 더해준다.
    // 2023년을 지정하고 싶으면 2023-1900을 넣어야한다.

    System.out.println(d2);

    // 1970년 1월 1일 0시 0분 0초부터 측정된 밀리초를 가지고
    // 날짜 인스턴스(객체=메모리) 초기화시킨다.
    Date d3 = new Date(1000L * 60 * 60 * 24 * 365 * 50);
    // 1년 * 50
    // long 값은 밀리
    System.out.println(d3);
  }
}














