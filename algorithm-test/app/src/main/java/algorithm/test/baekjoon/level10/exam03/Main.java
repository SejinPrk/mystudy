package algorithm.test.baekjoon.level10.exam03;
// 3009 네 번째 점
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] p1 = { sc.nextInt(), sc.nextInt() };
    int[] p2 = { sc.nextInt(), sc.nextInt() };
    int[] p3 = { sc.nextInt(), sc.nextInt() };

    sc.close();
    int x;
    int y;

    if(p1[0] == p2[0]){
      x = p3[0];
    }
    else if(p1[0] == p3[0]){
      x = p2[0];
    }
    else {
      x = p1[0];
    }

    if(p1[1] == p2[1]){
      y = p3[1];
    }
    else if(p1[1] == p3[1]){
      y = p2[1];
    }
    else {
      y = p1[1];
    }
    System.out.println(x + " " + y);
  }
}
