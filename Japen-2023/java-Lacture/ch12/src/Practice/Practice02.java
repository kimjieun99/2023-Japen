package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Practice02 extends JFrame {

  MyPanel myPanel = new MyPanel();

  Practice02() {
    this.setTitle(" ");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(myPanel);
    this.setSize(600, 800);
    this.setVisible(true);
  }

  class MyPanel extends JPanel {

    private ImageIcon icon = new ImageIcon("images/younjin.jpg");
    private Image img = icon.getImage();
    private int ovalX = 100;
    private int ovalY = 100;

    MyPanel() {
      this.addMouseMotionListener(
          new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
              ovalX = e.getX() - 15;
              ovalY = e.getY() - 15;
              repaint();
            }
          }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
      g.setColor(Color.GREEN);
      g.fillOval(ovalX, ovalY, 30, 30);
      // g.drawLine(0, 20, getWidth(), 20);
      // for (int i = 0; i < 50; i++) {
      //   g.drawLine(0, 20 * i, getWidth(), 20 * i);
      // }
      // for (int i = 0; i < 50; i++) {
      //   g.drawLine(20 * i, 0, 20 * i, getHeight());
      // }
      for (int i = 0; i < 50; i++) {
        g.drawLine(20 * i, 80, 40, 0);
      }
      //for (int i = 0; i < 50; i++) {
      //  g.drawLine(20 * i, 0, 20 * i, getHeight());
      //}
    }
  }

  public static void main(String[] args) {
    new Practice02();
  }
}
