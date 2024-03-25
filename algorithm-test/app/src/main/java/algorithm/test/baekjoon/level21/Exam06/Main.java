package algorithm.test.baekjoon.level21.Exam06;

import java.util.Scanner;

// 1149 RGB거리
public class Main {
  final static int Red = 0;
  final static int Green = 1;
  final static int Blue = 2;

  static int[][] cost;
  static int[][] DP;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    cost = new int[N][3];
    DP = new int[N][3];

    for (int i = 0; i < N; i++) {
      cost[i][Red] = sc.nextInt();
      cost[i][Green] = sc.nextInt();
      cost[i][Blue] = sc.nextInt();
    }

    DP[0][Red] = cost[0][Red];
    DP[0][Green] = cost[0][Green];
    DP[0][Blue] = cost[0][Blue];

    System.out.println(Math.min(Paint(N-1, Red), Math.min(Paint(N-1, Green), Paint(N-1, Blue))));
  }

  static int Paint(int N, int colour) {
    if(DP[N][colour] == 0) {
      if (colour == Red) {
        DP[N][Red] = Math.min(Paint(N-1, Green), Paint(N-1, Blue)) + cost[N][Red];
      } else if (colour == Green) {
        DP[N][Green] = Math.min(Paint(N-1, Red), Paint(N-1, Blue)) + cost[N][Green];
      } else {
        DP[N][Blue] = Math.min(Paint(N-1, Red), Paint(N-1, Green)) + cost[N][Blue];
      }
    }
    return DP[N][colour];
  }
}
