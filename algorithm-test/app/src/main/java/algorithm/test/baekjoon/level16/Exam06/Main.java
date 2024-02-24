package algorithm.test.baekjoon.level16.Exam06;

import java.util.Scanner;

// 1929 소수 구하기
public class Main {
  public static boolean[] prime;
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();

    prime = new boolean[n+1];
    get_prime();

    for (int i = m; i <= n; i++) {
      if(!prime[i]) {
        System.out.println(i);
      }
    }
  }

  public static void get_prime() {
    prime[0] = prime[1] = true;

    for (int i = 2; i <= Math.sqrt(prime.length); i++) {
      if (prime[i]) {
        continue;
      }
      for (int j = i * i; j < prime.length; j += i) {
        prime[j] = true;
      }
    }
  }
}
