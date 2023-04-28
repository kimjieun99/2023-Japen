package Practice;

import java.util.Calendar;

public class Practice05 {

  public static void main(String[] args) {
    Calendar now = Calendar.getInstance();
    int hour = now.get(Calendar.HOUR);
    int min = now.get(Calendar.MINUTE);
    System.out.println("현재 시각은 " + hour + "시 " + min + "분 입니다.");
    if (hour > 4 && hour < 12) {
      System.out.println("Good Morning");
    } else if (hour >= 12 && hour < 18) {
      System.out.println("Good Afternoon");
    } else if (hour >= 19 && hour < 22) {
      System.out.println("Good Evening");
    } else {
      System.out.println("Good Night");
    }
  }
}
