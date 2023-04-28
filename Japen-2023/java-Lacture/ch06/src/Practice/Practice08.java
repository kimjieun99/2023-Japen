package Practice;

import java.util.Scanner;

public class Practice08 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
      "문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다."
    );
    String txt = scanner.nextLine();
    int total = txt.length();
    for (int i = 0; i < total; i++) {
      String first = txt.substring(0, 1);
      String rest = txt.substring(1);
      txt = rest + first;
      System.out.println(txt);
    }
  }
}
