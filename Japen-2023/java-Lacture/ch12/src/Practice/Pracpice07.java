package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pracpice07 extends JFrame {

  MyPanel myPanel = new MyPanel();
  
  Pracpice07() {
    this.setTitle("드래깅 연습하기");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(myPanel);
    this.setSize(600, 800);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new Pracpice07();
  }
}
