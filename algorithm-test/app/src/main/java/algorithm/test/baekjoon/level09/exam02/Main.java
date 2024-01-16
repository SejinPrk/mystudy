package algorithm.test.baekjoon.level09.exam02;

import java.util.Scanner;

// 2501 약수 구하기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int cnt = 0;

    for (int i = 1; i <= N; i++){
      if(N % i == 0){
        cnt++;
      }

      if (cnt == K){
        System.out.println(i);
        break;
      }
    }
    if (cnt < K){
      System.out.println(0);
    }
  }
}
