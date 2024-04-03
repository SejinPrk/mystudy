package algorithm.test.baekjoon.level22.Exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//25682 체스판 다시 칠하기 2
public class Main {
  static int n,m,k,max = Integer.MIN_VALUE, min=Integer.MAX_VALUE;
  static int [][] board;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new int[n+1][m+1];

    boolean colour = false;

    for (int i = 1; i <= n; i++) {
      String str = br.readLine();
      for(int j = 1; j <= m; j++) {
        char c = str.charAt(j-1);
        if (!colour && c == 'W') board[i][j] = 1;
        else if (colour && c == 'B') board[i][j] = 1;
        colour = !colour;
      }
      if (m % 2 == 0) {
        colour = !colour;
      }
    }
    for (int i = 1; i <= n; i++) {
      int temp = board[i][1];
      for (int j = 2; j <= m; j++) {
        temp += board[i][j];
        board[i][j] = temp;
      }
    }

    for (int i = 1; i <= m; i++) {
      int temp = board[i][1];
      for (int j = 2; j <= n; j++) {
        temp += board[j][i];
        board[j][i] = temp;
      }
    }

    for (int i = k; i <= n; i++) {
      for (int j = k; j <= m; j++) {
        int temp = board[i][j] - (board[i-k][j] + board[i][j-k] - board[i-k][j-k]);
        min = Math.min(min, temp);
        max = Math.max(max, temp);
      }
    }
    int ans = Math.min(min, k*k - max);
    bw.write(ans + "");
    bw.flush();
    bw.close();
    br.close();
  }
}
