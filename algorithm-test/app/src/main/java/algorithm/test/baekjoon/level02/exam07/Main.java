package algorithm.test.baekjoon.level02.exam07;

import java.util.Scanner;

// 2480 주사위 세 개
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int d1 = sc.nextInt();
    int d2 = sc.nextInt();
    int d3 = sc.nextInt();
    sc.close();

    int r = 0;
    if (d1 == d2 && d2 == d3 && d3 == d1) {
      r = 10000 + d1 * 1000;

    } else if (d1 == d2 || d1 == d3) {
      r = 1000 + d1 * 100;
    } else if (d2 == d3){
      r = 1000 + d2 * 100;
    } else{
      int max = d1;
      if(max < d2) max = d2;
      if(max < d3) max = d3;
      r = max * 100;
    }
    System.out.println(r);
  }
}