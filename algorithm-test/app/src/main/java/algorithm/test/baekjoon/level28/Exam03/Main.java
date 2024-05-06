package algorithm.test.baekjoon.level28.Exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 17299 오등큰수
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());
    int[] data = new int[N];
    int[] cnt = new int[1000001];
    int[] ans = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      data[i] = Integer.parseInt(st.nextToken());
      cnt[data[i]]++;
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      while(!stack.isEmpty() && cnt[data[stack.peek()]] < cnt[data[i]]) {
        ans[stack.pop()] = data[i];
      }
      stack.add(i);
    }

    while (!stack.isEmpty()) {
      ans[stack.pop()] = -1;
    }

    for (int i = 0; i < N; i++) {
      sb.append(ans[i]).append(" ");
    }

    System.out.println(sb);
  }
}
