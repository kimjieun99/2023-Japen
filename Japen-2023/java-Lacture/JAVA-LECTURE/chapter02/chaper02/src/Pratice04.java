import java.util.Scanner;

public class Pratice04 {
    public static void main(String[] args) {
        System.out.println("정수 세개를 입력하면 중간 값은? ");
        
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int center = a;
        if((a>=b && a<=c)||(a>=c && a<=b)) {
            center = a;
        } else if((b>=a && b<=c)||(b>=c && b<=a)) {
            center = b;
        } else {
            center = c;
        }
        
        System.out.println("중간값은 "+center+"입니다.");
    }
}
