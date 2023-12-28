package bitcamp.util;

public class Test {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa"); // aaa
    list.add("bbb"); // aaa bbb
    list.add("ccc"); // aaa bbb ccc
    list.add("ddd"); // aaa bbb ccc ddd

    System.out.println(list.remove("xxx")); // aaa bbb ccc ddd
    System.out.println(list.remove("ccc")); // aaa bbb ddd
    System.out.println(list.remove("ddd")); // aaa bbb
    System.out.println(list.remove("aaa")); // bbb
    System.out.println(list.remove("bbb")); //

    list.add("xxx");
    list.add("yyy");
    list.add("zzz");


//    list.remove(2); // aaa bbb ddd
//     list.remove(1); // aaa ddd
//    list.remove(0); // bbb
//    list.remove(0); //


//    // 맨 앞
//    list.add(0, new String("xxx")); // xxx aaa bbb ccc ddd
//    // 맨 뒤
//    list.add(5, new String("yyy")); // xxx aaa bbb ccc ddd yyy
//    // 기존 값 자리
//    list.add(1, new String("mmm")); // xxx mmm aaa bbb ccc ddd yyy
//    list.add(3, new String("ttt")); // xxx mmm aaa ttt bbb ccc ddd yyy
//    list.add(7, new String("ppp")); // xxx mmm aaa ttt bbb ccc ddd ppp yyy

   String[] arr = list.toArray(new String[0]);
    for(String value:arr){
      System.out.printf("%s, ", value);
    }
    System.out.println();

//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4)); // 존재하지 않는 값 -> 호출 시 예외 발생

  }
}
