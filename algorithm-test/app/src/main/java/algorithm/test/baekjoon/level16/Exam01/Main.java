package algorithm.test.baekjoon.level16.Exam01;

import java.util.Scanner;

// 1934 최소공배수
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      int d = gcd(a, b);
      sb.append(a * b / d).append('\n');
    }
    System.out.println(sb);
  }

  public static int gcd(int a, int b) {

    while (b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
  }
}
