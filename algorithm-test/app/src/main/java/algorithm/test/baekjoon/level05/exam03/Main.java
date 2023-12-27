package algorithm.test.baekjoon.level05.exam03;
// 9086 문자열
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      String str = sc.next();

      String first = String.valueOf(str.charAt(0));
      String last = String.valueOf(str.charAt(str.length() - 1));

      System.out.println(first + last);
    }
    sc.close();
  }
}