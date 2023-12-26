package algorithm.test.baekjoon.level05.exam03;
// 27866 문자와 문자열
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
      String S = sc.nextLine();
      int i  = sc.nextInt()-1; // charAt는 0부터 시작하므로 -1

      System.out.println(S.charAt(i));
      sc.close();
  }
}
