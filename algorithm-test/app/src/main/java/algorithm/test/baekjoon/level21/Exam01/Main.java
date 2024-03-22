package algorithm.test.baekjoon.level21.Exam01;

// 24416 알고리즘 수업 - 피보나치 수 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int cnt1,  cnt2;

  static int[] f;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n =  Integer.parseInt(br.readLine());
    f = new int[n];

    br.close();

    cnt1 = 0;
    cnt2 = 0;

    fib(n);
    fibonacci(n);

    System.out.println(cnt1 + " " + cnt2);

  }

  static int fib(int n){
    if(n == 1 || n == 2){
      cnt1++;
      return 1;
    }
    else return (fib(n-1) + fib(n-2));
  }

  static int fibonacci(int n){
    f[0] = 1;
    f[1] = 1;

    for(int i = 2; i < n; i++){
      cnt2++;
      f[i] = f[i-1] + f[i-2];
    }
    return f[n-1];
  }
}