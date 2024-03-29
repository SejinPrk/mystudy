package algorithm.test.baekjoon.level15.Exam07;

import java.util.Scanner;

// 4948 베르트랑 공준
public class Main {

  public static boolean[] prime = new boolean[246913];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    get_prime();

    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      int cnt = 0;

      for (int i = n + 1; i <= 2 * n; i++) {
        if (!prime[i]) {
          cnt++;
        }
      }
      System.out.println(cnt);
    }
  }


  public static void get_prime() {
    prime[0] = prime[1] = true;
    for (int i = 2; i < Math.sqrt(prime.length); i++) {
      if (prime[i]) {
        continue;
      }
      for (int j = i * i; j < prime.length; j+=i) {
        prime[j] = true;
      }
    }
  }
}