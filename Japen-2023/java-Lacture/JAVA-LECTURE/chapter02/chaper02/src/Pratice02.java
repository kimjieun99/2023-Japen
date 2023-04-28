import java.util.Scanner;

public class Pratice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("두 자리 수 정수를 입력하세요.");
        int num = scanner.nextInt();
        int ten = num/10;
        int one = num%10;
        if(ten==one) {
            System.out.println("같다.");
        } else {
            System.out.println("다르다.");
        }
        scanner.close();
    }
}
