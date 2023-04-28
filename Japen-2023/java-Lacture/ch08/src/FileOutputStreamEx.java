import java.io.FileOutputStream;

public class FileOutputStreamEx {

  public static void main(String[] args) {
    byte b[] = { 4, 3, 5, 2, 3, 4, -1 };
    
    try {
      FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
      for (int i = 0; i < b.length; i++) {
        fout.wait(b[i]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
