package Practice;

import java.util.Scanner;
import java.util.Vector;

public class Practice01 {
  public static void main(String[] args) {
    Vector<Integer> vec = new Vector<>();
    System.out.println("정수를 입력하시오. -1을 입력하면 끝납니다.");
    Scanner scanner = new Scanner(System.in);

    while (true) {
      int num = scanner.nextInt();
      if (num == -1) break;
      vec.add(num);
    }
    int big = vec.get(0);
    for (int i = 1; i < vec.size(); i++) {
      if (vec.get(i) > big) {
        big = vec.get(i);
      }
    }
    System.out.println("제일 큰 숫자는 " + big);
  }
}