import java.util.Scanner;

public class Prapice06 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1~99 사이의 정수를 입력하시오.");

    int num = scanner.nextInt();
    int ten = num / 10;
    int one = num % 10;
    int count = 0;
    if (ten%3==0) {
        count++;
    } if(one%3==0) {
        count++;
    } if(count==1) {
        System.out.println("박수짝");
    } if(count==2) {
        System.out.println("박수짝짝");
    } else {
        System.out.println("박수 치지마.");
    }
  }
}
