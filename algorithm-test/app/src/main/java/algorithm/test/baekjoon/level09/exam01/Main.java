package algorithm.test.baekjoon.level09.exam01;

import java.util.Scanner;

// 5086 배수와 약수
public class Main {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  while(true){
    int a = sc.nextInt();
    int b = sc.nextInt();
    if(a == 0 && b == 0) break;
    if(b % a == 0){
      System.out.println("factor");
    }
    else if(a % b == 0){
      System.out.println("multiple");
    } else{
      System.out.println("neither");
      }
    }
  }
}
