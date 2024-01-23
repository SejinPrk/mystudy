package algorithm.test.baekjoon.level10.exam02;
// 1085 직사각형에서 탈출
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int x_min = Math.min(x, w-x);
    int y_min = Math.min(y, h-y);

    System.out.println(Math.min(x_min, y_min));

  }
}
