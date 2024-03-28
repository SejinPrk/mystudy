package algorithm.test.baekjoon.level21.Exam12;

import java.util.Scanner;

// 11053 가장 긴 증가하는 부분 수열
public class Main {
  static int[] seq;
  static Integer[] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    seq = new int[N];
    dp = new Integer[N];

    for (int i = 0; i < N; i++) {
      seq[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      LIS(i);
    }

    int max = dp[0];

    for (int i = 1; i < N; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }

  static int LIS (int N) {
    if (dp[N] == null) {
      dp[N] = 1;

      for (int i = N-1; i >= 0; i--) {
        if (seq[i] < seq[N]) {
          dp[N] = Math.max(dp[N], LIS(i) + 1);
        }
      }
    }
    return dp[N];
  }
}
