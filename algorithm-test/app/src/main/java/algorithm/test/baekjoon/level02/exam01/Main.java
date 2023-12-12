package algorithm.test.baekjoon.level02.exam01;
//1330 두 수 비교하
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    sc.close();
    if (A>B)
      System.out.println(">");
    if(A<B)
      System.out.println("<");
    if (A==B)
      System.out.println("==");
  }
}
