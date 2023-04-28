import java.util.Scanner;

public class Break {

  public static void main(String[] args) {
    System.out.println("exit를 입력하면 종료합니다.");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(">>");
      String text = scanner.nextLine();
      //primetive//
      if (text.equals("exit")) {
        break; //반복문 빠져 나갈 때
      }
    }
    System.out.println("종료");
    scanner.close();
  }
}
