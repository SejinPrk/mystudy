package algorithm.test.baekjoon.level20.Exam05;

import java.util.Scanner;

// 9663 N-Queen
public class Main {
  public static int[] arr;
  public static int N;
  public static int cnt = 0;

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      arr = new int[N];

      nQueen(0);
      System.out.println(cnt);
  }

  public static void nQueen(int depth) {
    if (depth == N) {
      cnt++;
      return;
    }

    for (int i = 0; i < N; i++) {
      arr[depth] = i;
      if (possibility(depth)) {
        nQueen(depth + 1);
      }
    }
  }

  public static boolean possibility(int col) {
   for (int i = 0; i < col; i++) {
     if (arr[col] == arr[i]) {
       return false;
     } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
       return false;
     }
   }
   return true;
  }
}
