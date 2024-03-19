package algorithm.test.baekjoon.level18.Exam04;

import java.util.Scanner;

// 2108 통계학
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[8001];

    int sum = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int median = 10000;
    int mode = 10000;

    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      sum += val;
      arr[val + 4000] ++;

      if (max < val) {
        max = val;
      }
      if (min > val) {
        min = val;
      }
    }

    int cnt = 0;
    int max_mode = 0;

    boolean flag = false;

    for (int i = min + 4000; i <= max + 4000 ; i++) {
      if (arr[i] > 0) {
        if (cnt < (n+1)/2) {
          cnt += arr[i];
          median = i - 4000;
        }

        if (max_mode < arr[i]) {
          max_mode = arr[i];
          mode = i - 4000;
          flag = true;
        } else if (max_mode == arr[i] && flag == true) {
          mode = i - 4000;
          flag = false;
        }
      }
    }
    System.out.println((int)Math.round((double)sum /n));
    System.out.println(median);
    System.out.println(mode);
    System.out.println(max - min);
  }

}
