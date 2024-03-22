package algorithm.test.baekjoon.level21.Exam02;

import com.sun.source.tree.BreakTree;
import java.util.Scanner;

// 9184 신나는 함수 실행
public class Main {
  static int[][][] dp = new int[21][21][21];
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (a == -1 && b == -1 && c == -1) {
        break;
      }

      System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
    }
  }

  static int w(int x, int y, int z) {
    if (inRange(x, y, z) && dp[x][y][z] != 0) {
      return dp[x][y][z];
    }
  }

  static boolean inRange(int a, int b, int c) {}
  return 0 <= a && a <= 20 && 0 <= b &&
}
