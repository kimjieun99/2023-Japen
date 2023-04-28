package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Practice07 {

  public static void main(String[] args) {
    File src = new File("C:\\Windows\\Web\\Wallpaper\\Windows\\img19.jpg");
    File destination = new File("c:\\Temp\\copy.jpg");
    int c;
    try {
      FileInputStream fi = new FileInputStream(src);
      FileOutputStream fo = new FileOutputStream(destination);
      byte buffer[] = new byte[1024];
      int numRead = 0;
      while (true) {
        int n = fi.read(buffer);
        fo.write(buffer, 0, n);
        if (n < buffer.length) break;
        if (numRead > 10) {
          System.out.print("*");
        }
      }
      fi.close();
      fo.close();
      System.out.println("이미지 복사 끝");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
