import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int height = sc.nextInt();
    int weight = sc.nextInt();
    double height2 = Math.pow(height, 2);

    int BMI = weight*100*100/(int)height2;

    if(BMI >= 25){
      System.out.println(BMI);
      System.out.println("Obesity");

    } else{
      System.out.println(BMI);
    }
  }
}