package algorithm.test.baekjoon.level14.Exam11;
// 18870 좌표 압축

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] origin = new int[n];
    int[] sorted = new int[n];
    HashMap<Integer, Integer> rank = new HashMap<>();

    for (int i = 0; i < n; i++) {
      sorted[i] = origin[i] = sc.nextInt();
    }

    Arrays.sort(sorted);

    int ranking = 0;
    for (int j : sorted) {
      if (!rank.containsKey(j)) {
        rank.put(j, ranking);
        ranking++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int key : origin) {
      int rank2 = rank.get(key);
      sb.append(rank2).append(' ');
    }
    System.out.println(sb);
  }
}