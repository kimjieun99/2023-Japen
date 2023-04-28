import java.util.Scanner;

public class Prapice13 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
      "가위가위보 게임입니다. 가위, 바위, 보 중에서 입력하세요."
    );
    System.out.println("철수>>");
    String chulsu = scanner.next();
    System.out.println("영희>>");
    String younghee = scanner.next();
    if (chulsu.equals("가위")) {
      if (younghee.equals("바위")) {
        System.out.println("영희가 이겼음");
      } else if (younghee.equals("가위")) {
        if (chulsu.equals("바위")) {
          System.out.println("철수가 이겼음");
        }
      }
    }
  }
}
