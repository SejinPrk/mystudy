package algorithm.test.baekjoon.level19.Exam01;

import java.util.Scanner;

// 1037 약수
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    while(T-- > 0) {
      int N = sc.nextInt();
      max = N > max ? N : max;
      min = N < min ? N : min;
    }
    System.out.println(min * max);
  }
}
