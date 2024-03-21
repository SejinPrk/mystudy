package algorithm.test.baekjoon.level20.Exam08;

// 14889 스타트와 링크

import java.util.Scanner;

public class Main {
  static int N;
  static int[][] map;
  static boolean[] visit;
  static int MIN = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    map = new int[N][N];
    visit = new boolean[N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = sc.nextInt();
      }
    }
    comb(0, 0);
    System.out.println(MIN);
  }

  static void comb(int idx, int cnt) {
    if (cnt == N / 2) {
      diff();
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        comb(i + 1, cnt + 1);
        visit[i] = false;
      }
    }
  }

  static void diff() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < N-1; i++) {
      for (int j = i+1; j < N; j++) {
        if (visit[i] == true && visit[j] == true) {
          start += map[i][j];
          start += map[j][i];
        } else if (visit[i] == false && visit[j] == false) {
          link += map[i][j];
          link += map[j][i];
        }
      }
    }

    int val = Math.abs(start - link);

    if (val == 0) {
      System.out.println(val);
      System.exit(0);
    }
    MIN = Math.min(val, MIN);
  }
}