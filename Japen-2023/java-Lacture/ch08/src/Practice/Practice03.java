package Practice;

public class Practice03 {

  public static void main(String[] args) {
    java.io.FileReader fio = null;
    try {
      fio = new java.io.FileReader("c:\\windows\\system.ini");
      int c;
      while ((c = fio.read()) != -1) {
        System.out.print((char) Character.toUpperCase(c));
      }
      fio.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
