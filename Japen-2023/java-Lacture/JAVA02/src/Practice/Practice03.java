package Practice;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("졈수를 입력하시오.");
        int num = scanner.nextInt();
        for(int i=num;i>0;i--) {
            for(int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
