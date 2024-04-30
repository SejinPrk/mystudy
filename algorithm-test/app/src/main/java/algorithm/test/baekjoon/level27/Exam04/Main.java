package algorithm.test.baekjoon.level27.Exam04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2629 양팔저울
public class Main {
  static int N;
  static int[] w;
  static boolean[][] ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    w = new int[N];
    ans = new boolean[N+1][40001];

    for (int i = 0; i < N; i++) {
      int src = Integer.parseInt(st.nextToken());
      w[i] = src;
    }

    dp(0,0);

    for (int j = 0; j < 20; j++) {
      if (ans[N][j]) {
        System.out.println(j);
        System.out.println(ans[N][j] + " ");
      }
    }

    int c = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < c; i++) {
      int t = Integer.parseInt(st.nextToken());
      if (ans[N][t]) {
        sb.append("Y ");
      } else {
        sb.append("N ");
      }
    }
    System.out.println(sb.toString());
  }

  static void dp(int cnt, int num) {
    if (ans[cnt][num]) return;
    ans[cnt][num] = true;

    if (cnt == N) return;

    dp(cnt + 1, num + w[cnt]);
    dp(cnt + 1, num);
    dp(cnt + 1, Math.abs(num - w[cnt]));
  }
}
