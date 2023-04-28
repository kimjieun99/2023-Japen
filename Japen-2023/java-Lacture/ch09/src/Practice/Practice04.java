package Practice;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice04 extends JFrame{

  public Practice04() {
    setTitle("Ten Color Buttons Frame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
    Container contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(0, 10, 0, 0));
    contentPane.add(new JLabel("0"));
    contentPane.add(new JLabel("1"));
    contentPane.add(new JLabel("2"));
    contentPane.add(new JLabel("3"));
    contentPane.add(new JLabel("4"));
    contentPane.add(new JLabel("5"));
    contentPane.add(new JLabel("6"));
    contentPane.add(new JLabel("7"));
    contentPane.add(new JLabel("8"));
    contentPane.add(new JLabel("9"));
  }

  public static void main(String[] args) {
    new Practice04();
  }
}
