import java.util.Vector;

public class Iterator {

  public static void main(String[] args) {
    Vector<Integer> vec = new Vector<>();
    vec.add(100);
    vec.add(120);
    vec.add(140);
    vec.add(160);
    vec.add(180);

    java.util.Iterator<Integer> it = vec.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
