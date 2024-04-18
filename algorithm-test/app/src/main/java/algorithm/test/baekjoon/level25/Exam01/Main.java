package algorithm.test.baekjoon.level25.Exam01;

import java.util.Arrays;
import java.util.Scanner;

// 1920 수 찾기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    int M = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      if (binary(arr, sc.nextInt()) >= 0) {
        sb.append(1).append('\n');
      } else {
        sb.append(0).append('\n');
      }
    }
    System.out.println(sb);
  }

  public static int binary(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (key < arr[mid]) {
        hi = mid - 1;
      } else if (key > arr[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
