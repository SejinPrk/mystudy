package algorithm.test.baekjoon.level03.exam09;

import java.util.Scanner;

// 2438 별 찍기-1
public class Main {
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for(int i=1; i<=N; i++){
      for(int j = 1; j <= i; j++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
