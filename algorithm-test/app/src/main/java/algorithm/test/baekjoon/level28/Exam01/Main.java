package algorithm.test.baekjoon.level28.Exam01;
// 9935 문자열 폭발
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String regex = br.readLine();
    int rSize = regex.length();

    Stack<Character> st = new Stack<>();

    for (int i = 0; i < line.length(); i++) {
      st.push(line.charAt(i));

      if (st.size() >= rSize) {
        boolean flag = true;

        for (int j = 0; j < rSize; j++) {
          if (st.get(st.size() - rSize + j) != regex.charAt(j)) {
            flag = false;
            break;
          }
        }if (flag) {
          for (int j = 0; j < rSize; j++) {
            st.pop();
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : st) {
      sb.append(c);
    }
    System.out.println(sb.length()==0? "FRULA" : sb.toString());
  }
}
