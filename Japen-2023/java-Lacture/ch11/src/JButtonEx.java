import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonEx extends JFrame {

  public JButtonEx() {
    ImageIcon imgIcon = new ImageIcon("images/heart.png");
    ImageIcon imgOverIcon = new ImageIcon("images/heart.png");
    ImageIcon imgPressIcon = new ImageIcon("images/heart.png");
    JButton btn = new JButton("button");
    JButton imgbtn = new JButton(imgIcon);
    imgbtn.setBorderPainted(false);
    imgbtn.setContentAreaFilled(false);
    imgbtn.setFocusPainted(false);
    imgbtn.setPressedIcon(imgPressIcon);
    imgbtn.setRolloverIcon(imgOverIcon);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new FlowLayout());
    add(btn);
    add(imgbtn);

    this.setSize(500, 500);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new JButtonEx();
  }
}
