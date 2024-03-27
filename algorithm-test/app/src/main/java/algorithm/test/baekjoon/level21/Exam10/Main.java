package algorithm.test.baekjoon.level21.Exam10;

import java.util.Scanner;

// 10844 쉬운 계단 수
public class Main {
  static Long[][] dp;
  static int N;
  final static long MOD = 1000000000;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    dp = new Long[N+1][10];

    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1L;
    }

    long result = 0;

    for (int i = 1; i <= 9; i++) {
      result += recur(N, i);
    }
    System.out.println(result % MOD);
  }

  static long recur(int d, int val) {
    if (d == 1) {
      return dp[d][val];
    }

    if (dp[d][val] == null) {
      if (val == 0) {
        dp[d][val] = recur(d-1, 1);
      } else if (val == 9) {
        dp[d][val] = recur(d-1, 8);
      } else {
        dp[d][val] = recur(d-1, val-1) + recur(d-1, val + 1);
      }
    }
    return dp[d][val];
  }
}
