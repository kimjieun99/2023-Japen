import java.util.Scanner;

public class Pratice01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("원화를 입력하면 달러로 환전해 드립니다.");
    final double rate = 1100;//final 붙이면 상수됨
    int won = scanner.nextInt();
    double dollar = won/rate;
    System.out.println("입력한 원화 "+won+"은 달러로 바꾸면 "+dollar+"입니다.");
  }
}
