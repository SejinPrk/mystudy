package algorithm.test.baekjoon.level01.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //int BuddhistYear = sc.nextInt();
    int ADyear = sc.nextInt();
    sc.close();
    //int ADyear= BuddhistYear - 543;
    int BuddhistYear = ADyear - 543;
    //System.out.println(ADyear);
    System.out.println(BuddhistYear);
  }
}
