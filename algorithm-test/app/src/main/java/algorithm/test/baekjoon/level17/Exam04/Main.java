package algorithm.test.baekjoon.level17.Exam04;

import java.util.Scanner;

//11050 이항 계수 1
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

      System.out.println(fac(n) / (fac(n-k) * fac(k)));
  }
    static int fac(int N) {
      if (N <= 1) {
        return 1;
      }
      return N * fac(N-1);
    }
}
