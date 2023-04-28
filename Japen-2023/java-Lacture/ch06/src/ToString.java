class Point02 {

  private int x, y;

  public Point02(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "Point(" + x + "," + y + ")";
  }

  @Override
  public boolean equals(Object obj) {
    Point02 p = (Point02) obj;
    if (x == p.x && y == p.y) {
      return true;
    } else {
      return false;
    }
  }
  //객체 비교는 equlas()
  //reference 는 ==
}

public class ToString {

  public static void main(String[] args) {
    Point02 p = new Point02(3, 5);
    System.out.println(p.toString());
    System.out.println(p);
    Point02 pp = new Point02(3, 5);

    if (p==pp) {
      System.out.println("같다.");
    } else {
      System.out.println("다르다.");
    }

    if (p.equals(pp)) {
      System.out.println("같다.");
    } else {
      System.out.println("다르다.");
    }
  }
}
