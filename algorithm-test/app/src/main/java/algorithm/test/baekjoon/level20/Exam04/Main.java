package algorithm.test.baekjoon.level20.Exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 24060 알고리즘 수업 - 병합 정렬 1
public class Main {
  int[] arr;
  static int[] temp;
  static int result = -1;
  static int cnt = 0;
  static int K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int [] arr = new int[N];
    temp = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    merge_sort(arr, 0, N-1);

    System.out.println(result);
  }

  static void merge_sort(int arr[], int p, int r) {
    if (cnt > K) return;
    if (p < r) {
      int q = (p+r) / 2;
      merge_sort(arr, p, q);
      merge_sort(arr, q+1, r);
      merge(arr, p, q, r);
    }
  }

  static void merge(int A[], int p, int q, int r) {
    int i = p;
    int j = q + 1;
    int t = 0;

    while (i <= q && j <= r) {
      if (A[i] < A[j]) {
        temp[t++] = A[i++];
      } else {
        temp[t++] = A[j++];
      }
    }

    while (i <= q) {
      temp[t++] = A[i++];
    }

    while (j <= r) {
      temp[t++] = A[j++];
    }

    i = p;
    t = 0;
    while (i <= r) {
      cnt++;

    if (cnt == K) {
      result = temp[t];
      break;
    }

    A[i++] = temp[t++];
    }
  }
}
