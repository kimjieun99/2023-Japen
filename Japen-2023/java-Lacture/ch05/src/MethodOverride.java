/**
 * InnerMethodOverride
 */
class Shape {

  public void draw() {
    System.out.println("Shape");
  }
}

class Line extends Shape {

  public void draw(String name) {
    System.out.println(name + "line");
  }
}

public class MethodOverride {

  public static void main(String[] args) {
    Shape shape = new Shape();
    shape.draw();
    Line line = new Line();
    line.draw();
  }
}
