package Practice;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

class WordSearch {
    File file = new File("c:\\Temp\\words.txt");
    Vector<String> wordList = new Vector<String>();
    private void {
    try {
        Scanner readWord = new Scanner(new FileReader(file));
        while(readWord.hasNext()) {
            String line = readWord.nextLine();
        }
    } catch (Exception e) {
    }
}
}

public class Practice11 {
    public static void main(String[] args) {
        WordSearch wordSearch =new WordSearch();
        wordSearch.run();
    }
}
