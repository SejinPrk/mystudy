package algorithm.test.baekjoon.level03.exam10;

import java.util.Scanner;

// 2439 별 찍기 - 2
public class Main {
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.close();

    for(int i=1; i<=N; i++){
      for(int j=1; j<=N-i; j++){
        System.out.print(" ");// 왼쪽부터 줄어드는 공백
      }
      for (int j=0; j<i; j++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
