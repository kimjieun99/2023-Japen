package Practice;

import java.util.HashMap;
import java.util.Scanner;

public class Practice03 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> nations = new HashMap<>();
    System.out.println("나라 이름과 인구를 입력하세요. ex) Korea 5000");

    while (true) {
      System.out.println("나라 이름, 인구 >>");
      String nation = scanner.nextLine();
      if (nation.equals("그만")) {
        break;
      }
      int population = scanner.nextInt();
      nations.put(nation, population);
    }
    while (true) {
      System.out.println("나라 이름을 쓰면 인구수를 알려드립니다.");
      String nation = scanner.next();
      if (nation.equals("그만")) break;
      Integer population = nations.get(nation);
      System.out.println(nations + "의 인구는 " + population);
      if (population == null) {
        System.out.println("해당하는 나라가 없습니다.");
      } else {
        System.out.println(nation + "의 인구는 " + population);
      }
    }
  }
}
