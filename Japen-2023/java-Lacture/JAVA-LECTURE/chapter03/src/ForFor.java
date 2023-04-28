public class ForFor {

  public static void main(String[] args) {
    //continue, break
    for (int i = 1; i <= 9; i++) {
      if (i % 2 == 0) {
        continue;
      }
      for (int j = 1; j <= 9; j++) {
        System.out.print(i + "x" + j + "=" + (i * j));
        System.out.print("\t");
      }
      System.out.println();
    }
  }
}
