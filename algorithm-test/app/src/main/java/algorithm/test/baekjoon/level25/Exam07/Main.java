package algorithm.test.baekjoon.level25.Exam07;

import java.util.Scanner;

// 12015 가장 긴 증가하는 부분 수열 2
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] seq = new int[N];
    int[] LIS = new int[N];

    for (int i = 0; i < N; i++) {
      seq[i] = sc.nextInt();
    }

    LIS[0] = seq[0];
    int length = 1;

    for (int i = 1; i < N; i++) {
      int key = seq[i];

      if (LIS[length-1] < key) {
        length++;
        LIS[length-1] = key;
      } else {
        int lo = 0;
        int hi = length;
        while (lo < hi) {
          int mid = (lo + hi) / 2;

          if (LIS[mid] < key) {
            lo = mid + 1;
          } else {
            hi = mid;
          }
        }

        LIS[lo] = key;
      }
    }
    System.out.println(length);
  }

}
