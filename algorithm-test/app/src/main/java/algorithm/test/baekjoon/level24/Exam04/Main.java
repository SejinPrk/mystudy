package algorithm.test.baekjoon.level24.Exam04;

import java.util.Scanner;

// 1629 곱셈
public class Main {
  public static long c;
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    c = sc.nextLong();

    System.out.println(pow(a,b));
  }

  public static long pow (long a, long ex) {
    if (ex == 1) {
      return a % c;
    }
    long tmp = pow(a, ex / 2);

    if (ex % 2 == 1) {
      return (tmp * tmp % c) * a % c;
    }
    return tmp * tmp % c;
  }
}
