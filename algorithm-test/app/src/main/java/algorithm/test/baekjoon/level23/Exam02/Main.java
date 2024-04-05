package algorithm.test.baekjoon.level23.Exam02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 1931 회의실 배정
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] time = new int[N][2];

    for (int i = 0; i < N; i++) {
      time[i][0] = sc.nextInt();
      time[i][1] = sc.nextInt();
    }

    Arrays.sort(time, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
          return o1[0] = o2[0];
        }
        return o1[1] - o2[1];
      }
    });

    int cnt = 0;
    int prev_end_time = 0;

    for (int i = 0; i < N; i++) {
      if (prev_end_time <= time[i][0]) {
        prev_end_time = time[i][1];
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
