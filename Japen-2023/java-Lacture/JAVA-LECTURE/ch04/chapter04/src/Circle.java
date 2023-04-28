public class Circle {

  //속성
  public int radius;
  public String name;
  public int width;

  public Circle() {
    radius = 10;
    System.out.println("나는 Circle");
  }

  public Circle(int radius) {
    this.radius = radius;
  }

  public Circle(String name, int radius) {
    this.name = name;
    this.radius = radius;
  }

  //메서드
  public double getArea() {
    return 3.14 * radius * radius };
}