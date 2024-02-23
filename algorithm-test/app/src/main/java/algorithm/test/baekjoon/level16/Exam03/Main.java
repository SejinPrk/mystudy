package algorithm.test.baekjoon.level16.Exam03;
// 1735 분수 합

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int num = a * d + b * c;
    int den = b * d;

    int mod = gcd(num, den);
    num /= mod;
    den /= mod;

    bw.write(num + " " + den + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int gcd(int a, int b){
  if(a <= b) {
    int tmp = a;
    a = b;
    b = tmp;
    }
  if (b == 0) {
    return a;
    }
    return gcd(b, a%b);
  }
}
