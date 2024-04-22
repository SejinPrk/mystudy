package algorithm.test.baekjoon.level25.Exam06;

import java.util.Scanner;

// 1300 K번째 수
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    long lo = 1;
    long hi = K;

    while (lo < hi) {
      long mid = (lo + hi) / 2;
      long cnt = 0;

      for (int i = 1; i <= N; i++) {
        cnt += Math.min(mid/ i, N);
      }

      if (K <= cnt) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    System.out.println(lo);
  }
}
