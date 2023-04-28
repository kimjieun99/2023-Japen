package Practice;

import java.util.Scanner;

abstract class Calc {

  protected int a;
  protected int b;

  public void setValue(int a, int b) {
    this.a = a;
    this.b = b;
  }

  abstract int calculate();
}

class Add extends Calc {

  int calculate() {
    return a + b;
  }
}

class Sub extends Calc {

  int calculate() {
    return a - b;
  }
}

class Mul extends Calc {

  int calculate() {
    return a * b;
  }
}

class Div extends Calc {

  int calculate() {
    return a / b;
  }
}

public class Practice11 {

  public static void main(String[] args) {
    System.out.println("두 정수와 연산자를 입력하시오. >>");
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    String op = scanner.next();
    Calc calc = null;

    if (op.equals("+")) {
      calc = new Add();
    } else if (op.equals("-")) {
      calc = new Sub();
    } else if (op.equals("*")) {
      calc = new Mul();
    } else if (op.equals("/")) {
      calc = new Div();
    }
    calc.setValue(a, b);
    int result = calc.calculate();
    System.out.println(result);
  }
}
