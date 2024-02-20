package algorithm.test.baekjoon.level16.Exam03;
// 1735 분수 합
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str[] = new String[n];
    int cnt = 0;
    int sum = 0;

    for(int i = 0; i < n; i++) {
      str[i] = sc.next();
      sum += str[i].length();
    }

    for(int i = 0; i < n; i++) {
      for (int j = 0; j < str[i].length(); j++) {
        if(str[n].charAt(j) == str[0].charAt(0)){
          cnt++;
        }
      }
    }

    System.out.println(sum + " " + cnt);
  }
}
