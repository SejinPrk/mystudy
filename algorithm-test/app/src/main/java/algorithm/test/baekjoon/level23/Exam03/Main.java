package algorithm.test.baekjoon.level23.Exam03;

import java.util.Arrays;
import java.util.Scanner;

// 11399 ATM
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    int prev = 0;
    int sum = 0;

    for (int i = 0; i < N; i++) {
      sum += prev + arr[i];
      prev += arr[i];
    }
    System.out.println(sum);
  }
}
