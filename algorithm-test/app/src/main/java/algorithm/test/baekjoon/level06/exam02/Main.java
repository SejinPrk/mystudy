package algorithm.test.baekjoon.level06.exam02;

import java.util.Scanner;

// 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int king = 1;
    int queen = 1;
    int rook = 2;
    int bishop = 2;
    int knight = 2;
    int pawn = 8;

    king = king - sc.nextInt();
    queen = queen - sc.nextInt();
    rook = rook - sc.nextInt();
    bishop = bishop - sc.nextInt();
    knight = knight - sc.nextInt();
    pawn = pawn - sc.nextInt();

    System.out.print(king + " ");
    System.out.print(queen + " ");
    System.out.print(rook + " ");
    System.out.print(bishop + " ");
    System.out.print(knight + " ");
    System.out.print(pawn + " ");
  }

}
