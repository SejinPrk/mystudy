package algorithm.test.baekjoon.level25.Exam05;

import java.util.Arrays;
import java.util.Scanner;

// 2110 공유기 설치
public class Main {
  public static int[] house;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    house = new int[N];

    for (int i = 0; i < N; i++) {
      house[i] = sc.nextInt();
    }

    Arrays.sort(house);

    int lo = 1;
    int hi = house[N - 1] - house[0] + 1;

    while (lo < hi) {
      int mid = (hi + lo) / 2;

      if (install(mid) < M) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    System.out.println(lo - 1);
  }

  public static int install(int d) {
    int cnt = 1;
    int last = house[0];

    for (int i = 1; i < house.length; i++) {
      int locate = house[i];

      if (locate - last >= d) {
        cnt++;
        last = locate;
      }
    }
    return cnt;
  }
}
