package algorithm.test.baekjoon.level09.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 9506 약수들의 합
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder str = new StringBuilder();

    while(true){
      int N = Integer.parseInt(br.readLine());
      if(N == -1)
        break;

      // 약수를 담아 둘 list
      ArrayList<Integer> list = new ArrayList<>();
      // 조건에 부합하는지
      int sum = 0;

      for(int i = 1; i < N; i++){
        // 약수라면 list에 추가하고 합을 구한다.
        if(N % i == 0) {
          list.add(i);
          sum += i;
        }
      }
      str.append(N);
      if(N == sum) {
        str.append(" = ");
        for (int i = 0; i < list.size()-1; i++)
          str.append(list.get(i) + " + ");
        str.append(list.get(list.size()-1));
      }
      else
        str.append(" is NOT perfect.");
      str.append("\n");
    }

    System.out.print(str);
    br.close();
  }
}
