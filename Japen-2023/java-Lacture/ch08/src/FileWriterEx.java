import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterEx {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter();
      while (true) {
        String line = scanner.nextLine();
        if (line.length() == 0) {
          break;
        }
      }
      fileWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
