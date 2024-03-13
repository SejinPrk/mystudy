package algorithm.test.baekjoon.level18.Exam03;

import java.util.Scanner;

//10872 팩토리얼
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int fac = 1;

    for (int i = 1; i <= n; i++) {
      fac *= i;
    }
    System.out.println(fac);
  }
}
