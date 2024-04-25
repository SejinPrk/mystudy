package algorithm.test.baekjoon.level27.Exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11066 파일 합치기
public class Main {
 public static int[] sum = new int[501];
 public static int[][] DP = new int[501][501];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < T; i++) {
      int K = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= K; j++) {
        sum[j] = sum[j-1] + Integer.parseInt(st.nextToken());
      }
      file(K);
      bw.write(DP[1][K] + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  public static void file(int K) {
    for (int i = 2; i <= K; i++) {
      for (int j = i-1; j >= 1; j--) {
        DP[j][i] = Integer.MAX_VALUE;
        for (int k = j; k < i; k++) {
          DP[j][i] = Math.min(DP[j][i], DP[j][k] + DP[k+1][i]);
        }
        DP[j][i] += sum[i] - sum[j - 1];
      }
    }
  }
}
