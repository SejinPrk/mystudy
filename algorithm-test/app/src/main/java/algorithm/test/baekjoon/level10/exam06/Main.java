package algorithm.test.baekjoon.level10.exam06;

import java.util.Scanner;

// 10101 삼각형 외우기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int first = sc.nextInt();
    int second = sc.nextInt();
    int last = sc.nextInt();
    int sum = first + second + last;

    if(first + second + last != 180){
      System.out.println("Error");
    } else {
      if (first == 60 && second == 60 && last == 60) {
        System.out.println("Equilateral");
      } else if (first == second || second == last || first == last) {
        System.out.println("Isosceles");
      } else {
        System.out.println("Scalene");
      }
    }
  }
}
