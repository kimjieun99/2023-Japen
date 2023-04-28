package Practice;

import java.awt.*;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Practice03 extends JFrame {

  public Practice03() {
    setTitle("Ten Color Buttons Frame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
    Container contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(0, 10, 0, 0));
    contentPane.add(new JButton("0"));
    contentPane.add(new JButton("1"));
    contentPane.add(new JButton("2"));
    contentPane.add(new JButton("3"));
    contentPane.add(new JButton("4"));
    contentPane.add(new JButton("5"));
    contentPane.add(new JButton("6"));
    contentPane.add(new JButton("7"));
    contentPane.add(new JButton("8"));
    contentPane.add(new JButton("9"));
  }

  public static void main(String[] args) {
    new Practice03();
  }
}
