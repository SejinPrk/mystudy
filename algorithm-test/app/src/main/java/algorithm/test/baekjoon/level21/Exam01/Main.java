package algorithm.test.baekjoon.level21.Exam01;

import java.util.Scanner;

// 15649 N과 M(1)
public class Main {
  public static int[] arr;
  public static boolean[] visit;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    arr = new int[m];
    visit = new boolean[n];

    dfs(n, m, 0);
  }

  public static void dfs(int N, int M, int depth) {
    if (depth == M) {
      for (int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        arr[depth] = i + 1;
        dfs(N, M, depth + 1);
        visit[i] = false;
      }
    }
  }
}
