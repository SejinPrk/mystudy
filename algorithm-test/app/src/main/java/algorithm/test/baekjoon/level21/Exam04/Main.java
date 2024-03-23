package algorithm.test.baekjoon.level21.Exam04;

import java.util.Scanner;

// 9461 파도반 수열
public class Main {
  public static Long[] sequence = new Long[101];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sequence[0] = 0L;
    sequence[1] = 1L;
    sequence[2] = 1L;
    sequence[3] = 1L;

    int T = sc.nextInt();

    while(T --> 0) {
      int N = sc.nextInt();
      System.out.println(Padovan(N));
    }
  }

  public static long Padovan(int N) {
    if (sequence[N] == null) {
      sequence[N] = Padovan(N-2) + Padovan(N-3);
    }
    return sequence[N];
  }
}
