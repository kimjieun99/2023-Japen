public class ColorPoint extends Point {

  //상속
  private String color;

  public ColorPoint(int x, int y, String color) {
    super(x, y);
    this.color = color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void showColorPoint() {
    showPoint();
    System.out.println(color);
  }
}
