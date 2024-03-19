package algorithm.test.baekjoon.level20.Exam04;

import java.util.Scanner;

// 15652 N과 M(4)
public class Main {
  public static int N, M;
  public static int[] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[M];

    dfs(1, 0);
  }

  public static void dfs(int at, int depth){
    if (depth == M) {
      for (int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
      return;
    }

    for (int i = at; i <= N; i++) {
      arr[depth] = i;
      dfs(i, depth + 1);
    }
  }
}
