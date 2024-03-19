package algorithm.test.baekjoon.level13.Exam10;
// 10814 나이순 정렬

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[][] arr = new String[n][2];

    for (int i = 0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = st.nextToken();
      arr[i][1] = st.nextToken();
    }

    Arrays.sort(arr, new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
      }
    });

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
    }
    System.out.println(sb);

  }
}