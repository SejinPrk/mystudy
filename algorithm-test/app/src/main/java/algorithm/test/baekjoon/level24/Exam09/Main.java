package algorithm.test.baekjoon.level24.Exam09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6549 히스토그램에서 가장 큰 직사각형
public class Main {
  public static int[] histogram;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int N;
    while (true) {
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());

      if (N == 0) {
        break;
      }
      histogram = new int[N];

      for (int i = 0; i < N; i++) {
        histogram[i] = Integer.parseInt(st.nextToken());
      }
      sb.append(getArea(0, N-1)).append('\n');
      histogram = null;
    }
    System.out.println(sb);
  }


  public static long getArea(int l, int h) {
    if (l == h) {
      return histogram[l];
    }

    int mid = (l + h) / 2;

    long left = getArea(l, mid);
    long right = getArea(mid + 1, h);

    long max = Math.max(left, right);
    max = Math.max(max, getMidArea(l, h, mid));

    return max;
  }

  public static long getMidArea(int l, int h, int mid) {
    int toLeft = mid;
    int toRight = mid;
    long height = histogram[mid];
    long maxArea = height;

    while(l < toLeft && toRight < h) {
      if (histogram[toLeft - 1] < histogram[toRight + 1]) {
        toRight++;
        height = Math.min(height, histogram[toRight]);
      } else {
        toLeft--;
        height = Math.min(height, histogram[toLeft]);
      }

      maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
    }

    while (toRight < h) {
      toRight++;
      height = Math.min(height, histogram[toRight]);
      maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
    }

    while (l < toLeft) {
      toLeft--;
      height = Math.min(height, histogram[toLeft]);
      maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
    }
    return maxArea;
  }
}
