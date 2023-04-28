package Practice;

import java.util.Scanner;

public class Practice04 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("소문자 알파벳 하나를 입력하시오");
    String str = scanner.next(); //문자열
    //문자 하나
    char ch = str.charAt(0);
    for (char i = ch; i >= 'a'; i--) {
      for (char j = 'a'; j <= 'i'; j++) {
        System.out.print(j);
      }
      System.out.println();
    }
  }
}
