import java.io.File;
import java.io.FileReader;

public class TextCopy {
    public static void main(String[] args) {

        File src = new File("c:\\windows\\system.ini");
        File destination = new File("c:\\Temp\\system.out");
        int c;
        try {
        FileReader fr = new FileReader(src);
        FileReader fw = new FileReader(destination);
        while((c = fr.read())!=-1) {
            fw.write((char) c)
        }    
        } catch (Exception e) {

        }
        FileReader fr = new FileRedaer(src)
    }
}
