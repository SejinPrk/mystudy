package algorithm.test.baekjoon.level14.Exam02;
// 2587 대표값2

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int avg = 0;
    int median = 0;
    int arr[] = new int[5];

    for(int i = 0; i < 5; i++){
      arr[i] = sc.nextInt();
      sum += arr[i];
    }
    Arrays.sort(arr);
    avg = sum / 5;
    median = arr[2];

    System.out.println(avg + " " + median);
  }
}
