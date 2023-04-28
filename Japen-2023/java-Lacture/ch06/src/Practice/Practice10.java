package Practice;

import java.util.Scanner;

class Person01 {

  private String name;
  Scanner scanner = new Scanner(System.in);

  public Person01(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public boolean turn() {
    System.out.println(name + "님 <Enter>");
    scanner.nextLine();
    int nums[] = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = (int) (Math.random() * 3 + 1);
    }
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i] + "\t");
    }
    boolean result = true;
    for (int i = 0; i < nums.length; i++) {
      if (nums[0] != nums[i]) {
        result = false;
        break;
      }
    }
    return result;
  }
}

class Game10 {

  private Person01 person[] = new Person01[3];
  private Scanner scanner = new Scanner(System.in);

  public Game10() {
    for (int i = 0; i < person.length; i++) {
      System.out.println((i+1) + "번째 선수 이름을 입력하세요.");
      String name = scanner.nextLine();
      person[i] = new Person01(name);
    }
  }

  public void run() {
    int next = 0;
    while (true) {
      if (person[next].turn()) {
        System.out.println(person[next].getName() + "님이 이겼습니다.");
        break;
      } else {
        System.out.println("아쉽네요...");
        next++;
        next = next%person.length;
      }
    }
  }
}

public class Practice10 {

  public static void main(String[] args) {
    Game10 game = new Game10();
    game.run();
  }
}