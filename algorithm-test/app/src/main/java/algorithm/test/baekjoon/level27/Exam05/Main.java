package algorithm.test.baekjoon.level27.Exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2293 동전 1
public class Main {
  static int N, K;
  static int[] arr, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];
    dp = new int[K + 1];
    dp[0] = 1;

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      for (int j = arr[i]; j <= K; j++) {
        dp[j] += dp[j - arr[i]];
      }
    }
    System.out.println(dp[K]);
  }
}
