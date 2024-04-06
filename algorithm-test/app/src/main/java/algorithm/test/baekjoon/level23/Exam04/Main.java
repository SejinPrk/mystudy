package algorithm.test.baekjoon.level23.Exam04;

import java.util.Scanner;

// 1541 잃어버린 괄호
public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int sum = Integer.MAX_VALUE;
    String [] sub = sc.nextLine().split("-");

    for (int i = 0; i < sub.length; i++) {
      int tmp = 0;
      String[] add = sub[i].split("\\+");

      for (int j = 0; j < add.length; j++) {
        tmp += Integer.parseInt(add[j]);
      }

      if (sum == Integer.MAX_VALUE) {
        sum = tmp;
      } else {
        sum -= tmp;
      }
    }
    System.out.println(sum);
  }
}
