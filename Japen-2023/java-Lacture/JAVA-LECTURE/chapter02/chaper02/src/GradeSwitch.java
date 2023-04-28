import java.util.Scanner;

public class GradeSwitch {
    public static void main(String[] args) {
        System.out.println("점수를 입력하세요. 0~100");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        char grade;
        //if(score>=90) 
        //   grade = 'A';
        //else if(score>=80) 
        //   grade = 'B';
        //else if(score>=70)
        //   grade = 'C';
        //else if(score>=60) 
        //   grade = 'D';
        //else (score>=50)
        //   grade = 'F';
        //
        switch(score / 10) {
            //정수, 문자열
            case 10:
            case 9:
            grade ='A';
            break;
            case 8:
            grade = 'B';
            break;
            case 7:
            grade = 'C';
            break;
            case 6:
            grade = 'D';
            break;
            default:
            grade = 'F';
        }
        System.out.println("당신의 학점은 "+grade);
    }
}
