package eomcs.com.oop.ex02.step05;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
//
public class App {

  static class Calculator {
    // 인스턴스 변수(= non-static 변수)
    // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
    // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
    // - new 명령을 사용해서 만들어야 한다.
    // - 변수 선언 앞에 static이 붙지 않는다.
    int result = 0;

    // 메서드 작업 결과는 인스턴스 변수에 저장한다.

    static void plus(Calculator instance, int value) {
      // 인스턴스 변수를 다루는 메서드는 작업을 수행할 때 그 인스턴스 주소를 받아야 한다.
      // result 는 더이상 클래스 변수가 아니기 때문에 직접 접근할 수 없다.
      // 오직 인스턴스 주소를 통해서만 접근 할 수 있다.
      instance.result += value;
    }

    static void minus(Calculator instance, int value) {
      instance.result -= value;
    }

    static void multiple(Calculator instance, int value) {
      instance.result *= value;
    }

    static void divide(Calculator instance, int value) {
      instance.result /= value;
    }

    // 다음 메서드는 result 변수를 사용하지 않기 때문에
    // Calculator의 인스턴스 주소를 받을 필요가 없다.
    // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {

    // 다음 두 개의 식을 분리하여 계산해 보자!
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?
    //

    // 두 개의 식을 동시에 계산하고 싶은가?
    // 그럴려면 계산 결과를 개별적으로 관리할 수 있어야 한다.
    // 다음과 같이 각 식의 계산 결과를 보관할 메모리를 준비한다.
    Calculator c1 = new Calculator(); // 식1의 계산 결과를 보관할 메모리 준비
    Calculator c2 = new Calculator(); // 식2의 계산 결과를 보관할 메모리 준비

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 전달한다.
    Calculator.plus(c1, 2); // + 2
    Calculator.plus(c1, 3); // + 2 + 3
    Calculator.minus(c1, 1); // + 2 + 3 - 1
    Calculator.multiple(c1, 7); // + 2 + 3 - 1 * 7
    Calculator.divide(c1, 3); // + 2 + 3 - 1 * 7 / 3 = ?
    Calculator.plus(c2, 3); // + 3
    Calculator.multiple(c2, 2); // + 3 * 2
    Calculator.plus(c2, 7); // + 3 * 2 + 7
    Calculator.divide(c2, 4); // + 3 * 2 + 7 / 4
    Calculator.minus(c2, 5); // + 3 * 2 + 7 / 4 - 5 = ?

    // 식1의 계산 결과는 c1 인스턴스의 result 변수에 들어 있고,
    // 식2의 계산 결과는 c2 인스턴스의 result 변수에 들어 있다.
    // result 변수가 어떤 인스턴스에 있는 변수인지 지정해야 한다.

    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);

    // 각각의 계산식의 결과는 서로 다른 result 변수에 보관되기 때문에 새로 초기화시킬 필요가 없다.
    // c2.result=0;



  }
}

