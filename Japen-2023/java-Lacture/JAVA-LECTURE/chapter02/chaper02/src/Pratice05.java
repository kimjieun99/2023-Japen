import java.util.Scanner;

public class Pratice05 {

  public static void main(String[] args) {
    System.out.println("정수 3개를 입력하시오.");

    Scanner scanner = new Scanner(System.in);
    int point01 = scanner.nextInt();
    int point02 = scanner.nextInt();
    int point03 = scanner.nextInt();

    if (
      (point01 + point02) > point03 ||
      (point01 + point03) > point02 ||
      (point02 + point03) > point01
    ) {
        System.out.println("삼각형이 맞습니다.");
    } else {
        System.out.println("삼각형이 안됩니다.");
    }
  }
}
