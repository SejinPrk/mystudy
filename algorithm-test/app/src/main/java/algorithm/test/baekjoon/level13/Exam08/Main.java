package algorithm.test.baekjoon.level13.Exam08;
// 11651 좌표 정렬하기 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][0] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
    }
  System.out.println(sb);
}
}
