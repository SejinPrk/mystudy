package algorithm.test.baekjoon.level03.exam07;

import java.util.Scanner;
// 11021 A+B-7
public class Main {
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for(int i = 0; i < T; i++){
      int A = sc.nextInt();
      int B = sc. nextInt();
      System.out.printf("Case #%d: %d\n", i+1, A+B);
    }
    sc.close();
  }
}