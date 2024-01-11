package algorithm.test.baekjoon.level08.exam02;
// 11005 진법 변환 2


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    br.close();

    ArrayList<Character> list = new ArrayList<>();
    while(N > 0){
      if(N % B < 10){
        list.add((char)(N % B + '0'));
      }
      else{
        list.add((char)(n%b - 10 + 'A'));
      }
      n/=b;
    }

    for (int i = list.size()-1; i>= 0; i--){
      System.out.println(list.get(i));
    }
  }
}

