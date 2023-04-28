package Practice;

class Point03 {

  private int x;
  private int y;

  public Point03(int x, int y) {
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

class Point3D extends Point03 {

  private int z;

  public int getZ() {
    return z;
  }

  public void moveUp() {
    z++;
  }

  public void moveDown() {
    z--;
  }

  public void move(int x, int y, int z) {
    move(x, y);
    this.z = z;
  }

  public Point3D(int x, int y, int z) {
    super(x, y);
  }

  public String toString() {
    return "(" + getX() + "," + getY() + "," + getZ() + ")";
  }
}

public class Practice07 {

  public static void main(String[] args) {
    Point3D p3d = new Point3D(100, 100, 50);
    System.out.println(p3d.toString());
    p3d.moveUp();
    System.out.println(p3d.toString());
    p3d.moveDown();
    p3d.moveDown();
    System.out.println(p3d.toString());
  }
}
