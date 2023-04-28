package Practice;

import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

class Student01 {

  private String name;
  private double score;

  public Student01(String name, double score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getScore() {
    return this.score;
  }

  public void setScore(double score) {
    this.score = score;
  }
}

class Scholarship {

  private String title;
  private HashMap<String, Student> scoreMap = new HashMap<>();
  Scanner scanner = new Scanner(System.in);

  public Scholarship(String title) {
    this.title = title;
  }

  public void insertStudent() {
    System.out.println(title + "관리 시스템 입니다.");
    for (int i = 0; i < 5; i++) {
      System.out.println(" 이름과 학점 입력 >>");
      String name = scanner.next();
      double score = scanner.nextDouble();
      Student01 student01 = new Student01(name, score);
      scoreMap.put(name, student01);
    }
  }


}

public class Practice07 {

  public static void main(String[] args) {
  }
}