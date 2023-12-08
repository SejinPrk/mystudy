package algorithm.test.baekjoon.level01.exam02;
import java.util.Scanner;
public class Main {
 public static void main(String[] args) {
  Scanner Scan = new Scanner(System.in);

  System.out.println("A, B ");
  String strA = Scan.nextLine();
  System.out.println("B(B < 10): ");
  String strB = Scan.nextLine();

  int A = Integer.parseInt(strA);
  int B = Integer.parseInt(strB);
  int r = A + B;
  System.out.printf("A+B = %s", r);
 }
}
