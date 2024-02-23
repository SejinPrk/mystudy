package algorithm.test.baekjoon.level15.Exam03;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// 7785 회사에 있는 사람
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String name = sc.next();
      String status = sc.next();

      if (map.containsKey(name)) {
        map.remove(name);
      } else {
        map.put(name, status);
      }
    }

    ArrayList<String> list = new ArrayList<>(map.keySet());
    Collections.sort(list, Collections.reverseOrder());
    for (var i : list) {
      System.out.println(i + " ");
    }

  }
}
