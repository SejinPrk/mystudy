package algorithm.test.baekjoon.level27.Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11049 행렬 곱셈 순서
public class Main {
  static int N;
  static int INF = Integer.MAX_VALUE;
  static int[] arr;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N + 1];
    StringTokenizer st = null;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st .nextToken());
      arr[i] = a;
      arr[i+1] = b;
    }

    dp = new int[N][N];

    for (int i = 2; i < N+1; i++) {
      for (int j = 0; j < N-i+1; j++) {
        dp[j][j+i-1] = INF;
        for (int k = j; k < j+i-1; k++) {
          int value = dp[j][k] + dp[k+1][j+i-1] + (arr[j]  * arr[k+1] * arr[j+i]);
          dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
        }
      }
    }
    System.out.println(dp[0][N-1]);
  }
}
