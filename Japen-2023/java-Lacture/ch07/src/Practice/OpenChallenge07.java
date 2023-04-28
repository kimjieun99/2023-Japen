package Practice;

import java.util.Scanner;
import java.util.Vector;

class Word {

  private String eng;
  private String kor;

  public Word(String eng, String kor) {
    this.eng = eng;
    this.kor = kor;
  }

  public String getEng() {
    return this.eng;
  }

  public String getKor() {
    return this.kor;
  }
}

class WordQuiz {

  private Vector<Word> vec = new Vector<>();
  Scanner scanner = new Scanner(System.in);

  public WordQuiz(Vector<Word> vec) {
    vec.add(new Word("love", "사랑"));
    vec.add(new Word("animal", "동물"));
    vec.add(new Word("emotion", "감정"));
    vec.add(new Word("human", "인간"));
    vec.add(new Word("stock", "주식"));
    vec.add(new Word("trade", "거래"));
    vec.add(new Word("society", "사회"));
    vec.add(new Word("baby", "아기"));
    vec.add(new Word("honey", "꿀"));
    vec.add(new Word("dall", "인형"));
    vec.add(new Word("bear", "곰"));
    vec.add(new Word("picture", "사진"));
    vec.add(new Word("painting", "그림"));
    vec.add(new Word("fault", "오류"));
    vec.add(new Word("example", "보기"));
    vec.add(new Word("eye", "눈"));
    vec.add(new Word("statue", "조각상"));
  }
  public void GameStart() {
    System.out.println(
      "영어 단어 테스트 프로그램 `명품영어` " +
      "테스트를 시작합니다. (-1 을 입력하면 테스트를 종료합니다.)"
    );
    //while문
    while (true) {
      int[] Quiz = new int[17];
      //for문
      for (int i = 0; i <= 17; i++) {
        Quiz[i] = i;
      }
      int[] Pick = new int[4];
      //for문
      for (int i = 0; i <= 4; i++) {
        Pick[i] = Pick[(int) (Math.random() * 17)];
        //for...
        for (int j = 0; j < i; j++) {
          //if...
          if (Pick[i] == Pick[j]) {
            i--;
          }
        }
      }
      int randomPick = (int) (Math.random() * 4);
      int answerPick = Pick[randomPick];
      Word wordAnswer = vec.get(answerPick);

      System.out.print("<" + wordAnswer.getEng() + ">");

      //for문...
      for (int i = 0; i <= 4; i++) {
        if (i == randomPick) {
          System.out.println("Excellent !!");
        } else {
          System.out.println("No. !!");
        }
      }
      System.out.println(" >> ");
      int PickAnswer = scanner.nextInt();

      //if문...
      if(PickAnswer==-1) {
        break;
      }
      Word GameResult = vec.get(Pick[PickAnswer - 1]);
    }
  }
}
//매서드(함수)를 정의하는 이유
//기능을 단순화 자판기


public class OpenChallenge07 {

  public static void main(String[] args) {
    WordQuiz wordQuiz = new WordQuiz();
    wordQuiz.run();
  }
}