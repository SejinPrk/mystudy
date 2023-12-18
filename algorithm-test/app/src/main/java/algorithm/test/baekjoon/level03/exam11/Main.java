package algorithm.test.baekjoon.level03.exam11;

import java.util.Scanner;

// 10952 A+B -5
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    while(true){
      int A = sc.nextInt();
      int B = sc. nextInt();

      if(A==0 && B==0){
        sc.close();
        break;
      }
      System.out.println(A+B);
    }
  }
}
