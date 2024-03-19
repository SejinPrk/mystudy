package algorithm.test.baekjoon.level14.Exam06;
// 1764 듣보잡
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> hm = new HashMap<>();
    List<String> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      hm.put(br.readLine(), 1);
    }

    for (int i = 0; i < m; i++) {
      String name = br.readLine();hm.put(name, hm.getOrDefault(name, 0) + 1);
      if (hm.get(name) == 2) list.add(name);
    }

    StringBuilder sb = new StringBuilder();
    Collections.sort(list);
    sb.append(list.size() + "\n");
    for (String s : list) {
      sb.append(s + "\n");
    }
    System.out.print(sb);
  }
}
