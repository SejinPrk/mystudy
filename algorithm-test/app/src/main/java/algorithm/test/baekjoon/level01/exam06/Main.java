package algorithm.test.baekjoon.level01.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    sc.close();
    int r1 = A + B;
    int r2 = A - B;
    int r3 = A * B;
    int r4 = A / B;
    int r5 = A % B;

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(r3);
    System.out.println(r4);
    System.out.println(r5);
  }
}