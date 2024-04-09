package algorithm.test.baekjoon.level24.Exam02;

import java.util.Scanner;

// 1992 쿼드트리
public class Main {
  public static int[][] img;
  public static StringBuilder sb= new StringBuilder();
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    img = new int[N][N];

    for (int i = 0; i < N; i++) {
      String str = sc.next();

      for (int j = 0; j < N; j++) {
        img[i][j] = str.charAt(j) - '0';
      }
    }
    QuadTree(0,0,N);
    System.out.println(sb);
  }

  public static void QuadTree(int a, int b, int size) {
    if (isPossible(a, b, size)) {
      sb.append(img[a][b]);
      return;
    }

    int newSize = size / 2;
    sb.append('(');

    QuadTree(a, b, newSize);
    QuadTree(a, b + newSize, newSize);
    QuadTree(a + newSize, b, newSize);
    QuadTree(a + newSize, b + newSize, newSize);

    sb.append(')');
  }

  public static boolean isPossible(int a, int b, int size) {
    int value = img[a][b];

    for (int i = a; i < a+ size; i++) {
      for (int j = b; j < b + size; j++) {
        if (value != img[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
