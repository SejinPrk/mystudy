package algorithm.test.baekjoon.level15.Exam02;
// 13241 최소공배수

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextInt();
    long b = sc.nextInt();

    long gcd = getGCD(Math.max(a, b), Math.min(a,b));

    System.out.println((a*b)/gcd);
  }

  public static long getGCD(long a, long b){
    while(b>0) {
      long temp = a;
      a = b;
      b = temp%b;
    }
    return a;
  }
}
