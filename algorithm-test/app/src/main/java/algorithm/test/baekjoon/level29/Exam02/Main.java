package algorithm.test.baekjoon.level29.Exam02;
// 24480 알고리즘 수업 - 깊이 우선 탐색 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int N,M,R, count = 1;
  static int[] result;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //입력값 처리하는 BufferedReader
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //결과값 출력하는 BufferedWriter
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    //리스트 및 배열 초기화
    result = new int[N+1];
    visited = new boolean[N+1];
    for(int i=0;i<=N;i++)
      graph.add(new ArrayList<>());
    //그래프 값 저장
    for(int i=0;i<M;i++) {
      st = new StringTokenizer(br.readLine()," ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    dfs(R);
    for(int i=1;i<=N;i++)
      bw.write(result[i] + "\n");

    bw.flush();
    bw.close();
    br.close();

  }
  static void dfs(int cur) {
    visited[cur] = true;
    result[cur] = count++;
    Collections.sort(graph.get(cur), Collections.reverseOrder());
    for( Integer value : graph.get(cur)) {
      if(!visited[value]) {
        dfs(value);
      }
    }
  }
}