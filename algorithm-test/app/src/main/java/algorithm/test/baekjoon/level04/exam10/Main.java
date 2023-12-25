package algorithm.test.baekjoon.level04.exam10;

import java.util.Scanner;
// 1546 평균
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int arr[] = new int[N];

    long sum = 0;
    long M = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();

    for (int i = 0; i < N; i++) {
      if (M < arr[i]) {
        M = arr[i];
      }
        sum += arr[i];
    }
      System.out.println(sum* 100.0 / M / N);
    }
  }

