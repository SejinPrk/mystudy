package algorithm.test.baekjoon.level20.Exam07;

import java.util.Scanner;

// 14888 연산자 끼워넣기
public class Main {
  public static int MAX = Integer.MIN_VALUE;
  public static int MIN = Integer.MAX_VALUE;
  public static int[] operator = new int[4];
  public static int[] num;
  public static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    num = new int[N];

    for (int i = 0; i < N; i++) {
      num[i] = sc.nextInt();
    }

    for (int i = 0; i < 4; i++) {
      operator[i] = sc.nextInt();
    }

    dfs(num[0], 1);

    System.out.println(MAX);
    System.out.println(MIN);
  }

  public static void dfs(int number, int idx) {
    if (idx == N) {
      MAX = Math.max(MAX, number);
      MIN = Math.min(MIN, number);
      return;
    }
    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) {
        operator[i]--;

        switch (i) {
          case 0:
            dfs(number + num[idx], idx + 1);
            break;

          case 1:
            dfs(number - num[idx], idx + 1);
            break;

          case 2:
            dfs(number * num[idx], idx + 1);
            break;

          case 3:
            dfs(number / num[idx], idx + 1);
            break;
        }
        operator[i]++;
      }
    }
  }
}
