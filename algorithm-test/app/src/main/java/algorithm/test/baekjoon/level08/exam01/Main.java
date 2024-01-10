package algorithm.test.baekjoon.level08.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2745 진법 변환
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  = new StringTokenizer(br.readLine());

    String n = st.nextToken();
    int b = Integer.parseInt(st.nextToken());
    br.close();

    int temp = 1;
    int sum = 0;

    for (int i = n.length()-1; i>=0; i--) {
      char C = n.charAt(i);

      if ('A' <= C && C<= 'Z') {
        sum += (C - 'A' + 10) * temp;
      } else {
        sum += (C - '0') * temp;
      }
      temp *= b;
    }
    System.out.println(sum);
    }
  }

