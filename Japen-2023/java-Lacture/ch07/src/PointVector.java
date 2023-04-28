import java.util.Vector;

class Point03 {

  private int x;
  private int y;

  public Point03(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}

public class PointVector {

  public static void main(String[] args) {
    Vector<Point03> vec = new Vector<>();
    vec.add(new Point03(1, 1));
    vec.add(new Point03(2, 2));
    vec.add(new Point03(3, 3));

    //System.out.println(vec.get(0));

    vec.remove(0);

    for (int i = 0; i < vec.size(); i++) {
      Point03 p = vec.get(i);
      System.out.println(p);
    }
  }
}