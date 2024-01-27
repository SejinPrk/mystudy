package algorithm.test.baekjoon.level13.Exam04;
// 1018 체스판 다시 칠하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static boolean[][] arr;
  public static int min = 64;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new boolean[n][m];

    for(int i = 0; i < n; i++){
      String str = br.readLine();

      for(int j = 0; j < m; j++){
        if(str.charAt(j) == 'W') {
          arr[i][j] = true;
        } else {
          arr[i][j] = false;
        }
      }
    }

    int nrow = n-7;
    int mcol = m-7;

    for(int i = 0; i < nrow; i++){
      for (int j = 0; j < mcol; j++) {
        find(i,j);
      }
    }
    System.out.println(min);
  }

  public static void find(int a, int b) {
    int enda = a + 8;
    int endb = b + 8;
    int cnt = 0;

    boolean WB= arr[a][b];

    for(int i = a; i <enda; i++) {
      for (int j = b; j < endb; j++){
        if(arr[i][j] != WB) {
          cnt++;
        }
        WB = (!WB);
      }
      WB = !WB;
    }
    cnt = Math.min(cnt, 64 - cnt);
    min = Math.min(min, cnt);
  }
}
