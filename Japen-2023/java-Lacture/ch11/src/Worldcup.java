import java.awt.*;
import java.text.*;
import javax.swing.*;

public class Worldcup extends JFrame {

  public Worldcup() {
    this.setTitle("이상형 월드컵");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout()); title.setFont(new Format("나눔스퀘어", Font.BOLD, 24));
    title.setHorizontalAlignment(JLabel.CENTER);


    
    this.setSize(500, 500);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new Worldcup();
  }
}
