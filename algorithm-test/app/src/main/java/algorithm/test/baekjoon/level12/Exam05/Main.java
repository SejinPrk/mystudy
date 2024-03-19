package algorithm.test.baekjoon.level12.Exam05;
// 1436 영화감독 숌
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int num = 666;
    int cnt = 1;

    while (cnt != N){
      num++;
      if(String.valueOf(num).contains("666")) {
        cnt++;
      }
    }
    System.out.println(num);
  }
}
