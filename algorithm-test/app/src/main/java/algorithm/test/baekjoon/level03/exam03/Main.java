package algorithm.test.baekjoon.level03.exam03;

import java.util.Scanner;

// 8393 합
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int sum=0;
    for(int i = 0; i <= n; i++){
          sum+=i;
    }
    System.out.println(sum);
  }
}
