package algorithm.test.baekjoon.level19.Exam02;

import java.util.Scanner;

// 10870 피보나치 수 5
public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(fibonacci(N));
  }

  static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
  }
}
