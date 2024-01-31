package algorithm.test.baekjoon.level14.Exam07;
// 11650 좌표 정렬하기

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int [][] arr = new int[n][2];

    for(int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }

    Arrays.sort(arr, (a, b) -> {
      if(a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i =0; i<n; i++){
      sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
    }
    System.out.println(sb);
  }
}
