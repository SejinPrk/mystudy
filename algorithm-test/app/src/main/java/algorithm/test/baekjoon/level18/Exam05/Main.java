package algorithm.test.baekjoon.level18.Exam05;

import java.util.Scanner;

// 1001 다리 놓기
public class Main {
  static int[][] arr = new int[30][30];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      sb.append(comb(M,N)).append('\n');
    }
    System.out.println(sb);
  }

  static int comb(int n, int r) {
      if(arr[n][r] > 0) return arr[n][r];
      if (n == r || r == 0) return arr[n][r] = 1;

      return arr[n][r] = comb(n-1, r-1) + comb(n-1, r);
  }
}
