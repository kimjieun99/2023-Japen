public class Logical {

  public static void main(String[] args) {
    System.out.println(3 > 2);
    System.out.println(3 < 2);
    System.out.println(3 == 2);
    System.out.println(3 != 2);
    System.out.println(!(3 != 2));
    System.out.println(3 > 2 || 3 > 4);
    System.out.println(3 > 2 && 3 > 4);
    System.out.println(3 > 2 ^ 3 < 4);
    //삼항연산자
    int a = 5; //절대값 구하기***
    int b = 10;
    int s = a > b ? 1 : -1;
    int s2 = a > b ? a - b : b - a;
    if (a > b) {
      s = a - b;
    } else {
      s = b - a;
    }
    //if(a>b) {
    //    s=1;
    //} else {
    //    s=-1;
    //}
    System.out.println(s);
  }
}
