package algorithm.test.baekjoon.level14.Exam07;
// 1269 대칭 차집합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    Set<Integer> A = new HashSet<>();
    Set<Integer> B = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a; i++) {
      A.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b; i++) {
      B.add(Integer.parseInt(st.nextToken()));
    }

    int ans = 0;
    for(int num : A) {
      if(!B.contains(num)) {
        ans += 1;
      }
    }
    for(int num : B) {
      if(!A.contains(num)) {
        ans += 1;
      }
    }
    System.out.println(ans);
  }
}
