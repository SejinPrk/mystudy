package algorithm.test.baekjoon.level27.Exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7579 앱
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int ans = Integer.MAX_VALUE;

    int[] memory = new int[N];
    int[] cost = new int[N];
    int[][] dp = new int[N][100001];

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());

    for(int i = 0 ; i < N; i++){
      memory[i] = Integer.parseInt(st1.nextToken());
      cost[i] = Integer.parseInt(st2.nextToken());
    }

    for (int i = 0; i < N; i++) {
      int c = cost[i];
      int m = memory[i];

      for (int j = 0; j <= 10000; j++) {
        if (i == 0) {
          if (j >= c) dp[i][j] = m;
        } else {
          if (j >= c) dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
          else dp[i][j] = dp[i - 1][j];
        }
        if (dp[i][j] >= M) ans = Math.min(ans, j);
      }
    }
    System.out.println(ans);
  }
}
