package algorithm.test.baekjoon.level02.exam05;

import java.util.Scanner;

// 2884 알람 시계
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int M = sc.nextInt();
    sc.close();

    if (M < 45){
      H--;
      M = 60-(45-M);
      if (H < 0) {
        H = 23;
      }
      System.out.println(H + " " + M);
    }else{
      M = M-45;
      System.out.println(H + " " + M);
    }
  }
}
