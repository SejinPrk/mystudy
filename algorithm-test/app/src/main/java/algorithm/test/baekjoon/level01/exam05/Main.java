package algorithm.test.baekjoon.level01.exam05;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    sc.close();
    double r =  (double) A / B;
    System.out.println(r);
  }
}