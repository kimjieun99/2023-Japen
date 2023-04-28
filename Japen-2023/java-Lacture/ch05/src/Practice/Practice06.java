package Practice;

class Point02 {

  private int x;
  private int y;

  public Point02(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  protected void move(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class ColorPoint02 extends Point02 {

  private String color;

  public ColorPoint02() {
    this(0, 0);
  }

  public ColorPoint02(int x, int y) {
    super(x, y);
    color = "black";
  }

  public void setXY(int x, int y) {
    move(x, y);
  }

  public void setColor(String color) {
    this.color = color;
  }
  
}

public class Practice06 {

  public static void main(String[] args) {}
}
