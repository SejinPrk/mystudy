package algorithm.test.baekjoon.level23.Exam05;

import java.util.Scanner;

// 13305 주유소
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    long[] dist = new long[n-1];
    long[] cost = new long[n];

    for (int i = 0; i < n-1; i++) {
      dist[i] = sc.nextLong();
    }

    for (int i = 0; i < n; i++) {
      cost[i] = sc.nextLong();
    }

    long sum = 0;
    long minCost = cost[0];

    for (int i = 0; i < n - 1; i++) {
      if (cost[i] < minCost) {
        minCost = cost[i];
      }
      sum += (minCost * dist[i]);
    }
    System.out.println(sum);
  }

}
