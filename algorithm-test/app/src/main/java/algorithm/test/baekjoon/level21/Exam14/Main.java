package algorithm.test.baekjoon.level21.Exam14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 2565 전깃줄
public class Main {
  static Integer[] dp;
  static int[][] wire;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    dp = new Integer[N];
    wire = new int[N][2];

    for (int i = 0; i < N; i++) {
      wire[i][0] = sc.nextInt();
      wire[i][1] = sc.nextInt();
    }

    Arrays.sort(wire, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int max = 0;

    for (int i = 0; i < N; i++) {
      max = Math.max(recur(i), max);
    }

    System.out.println(N - max);
  }

  static int recur(int N) {
    if(dp[N] == null) {
      dp[N] = 1;

      for (int i = N+1; i < dp.length; i++) {
        if (wire[N][1] < wire[i][1]) {
          dp[N] = Math.max(dp[N], recur(i) + 1);
        }
      }
    }
    return dp[N];
  }
}
