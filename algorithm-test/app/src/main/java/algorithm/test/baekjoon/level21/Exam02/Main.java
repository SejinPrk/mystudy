package algorithm.test.baekjoon.level21.Exam02;

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

    if (x <= 0 || y <= 0 || z <= 0) {
      return 1;
    }

    if (x > 20 || y > 20 || z > 20) {
      return dp[20][20][20] = w(20,20,20);
    }

    if (x < y && y < z) {
        return dp[x][y][z] = w(x, y, z-1) + w(x, y-1, z-1) - w(x, y-1, z-1);
    }
    return dp[x][y][z] = w(x-1, y, z) + w(x-1, y-1, z) + w(x-1, y, z-1) - w(x-1, y-1, z-1);
  }

  static boolean inRange(int a, int b, int c) {
    return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
  }
}
