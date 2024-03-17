package algorithm.test.baekjoon.level20.Exam06;

import java.util.Scanner;

// 2447  별 찍기 - 10
public class Main {
  static char[][] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    arr = new char[n][n];

    star(0, 0, n, false);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(arr[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }

  static void star(int x, int y, int N, boolean blank) {
    if (blank) {
      for (int i = x; i  < x + N; i++) {
        for (int j = y; j < y + N; j++) {
          arr[i][j] = ' ';
        }
      }
      return;
    }

    if (N == 1) {
      arr[x][y] = '*';
      return;
    }

    int size = N/3;
    int cnt = 0;

    for (int i = x; i < x + N; i+= size) {
      for (int j = y; j < y + N; j+= size) {
        cnt++;
        if (cnt == 5) {
          star(i, j, size, true);
        } else {
          star(i, j, size, false);
        }
      }
    }
  }
}
