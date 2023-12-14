package algorithm.test.baekjoon.level03.exam01;

import java.util.Scanner;

// 2789 구구단
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    sc.close();

    for(int j=1; j<10;j++){
      System.out.println(i + " * " + j + " = " + i * j);
    }
  }
}
