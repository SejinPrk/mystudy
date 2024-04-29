package algorithm.test.baekjoon.level27.Exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1520 내리막 길
public class Main {
  static int M, N;
  static int[][] arr, dp;
  static int[] X = {-1, 0, 1, 0};
  static int[] Y = {0, 1, 0, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[M + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[M + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      for (int j = 1; j <= N; j++) {
        dp[i][j] = -1;
      }
    }

    bw.write(DFS(1,1) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int DFS(int x, int y) {
    if (x == M && y == N) {
      return 1;
    }
    if (dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 0;
    for (int i = 0; i < 4; i++) {
      int dx = x + X[i];
      int dy = y + Y[i];

      if (dx < 1 || dy < 1 || dx > M || dy > N) {
        continue;
      }
      if (arr[x][y] > arr[dx][dy]) {
        dp[x][y] += DFS(dx, dy);
      }
    }

      return dp[x][y];
  }
}
