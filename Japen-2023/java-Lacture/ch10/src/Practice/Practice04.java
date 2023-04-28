package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice04 extends JFrame {

  public Practice04() {
    this.setTitle("Left 키로 문자열 교체");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new FlowLayout());
    JLabel label = new JLabel("LOVE JAVA");
    StringBuffer sb = new StringBuffer(label.getText());
    label.addKeyListener(
      new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            char char01 = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(char01);
            System.out.println(sb);
          }
        }
      }
    );
    contentPane.add(label);
    this.setSize(300, 300);
    this.setVisible(true);
    label.setFocusable(true);
    label.requestFocus();
  }

  public static void main(String[] args) {
    new Practice04();
  }
}
