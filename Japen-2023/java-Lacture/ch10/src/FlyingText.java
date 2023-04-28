import KeyListenerEx.MyKeyListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class FlyingText extends JFrame {

  private JLabel label = new JLabel("Hello");

  public FlyingText() {
    this.setTitle("Flying Text");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contenPane = this.getContentPane();
    contenPane.addKeyListener(new MyKeyListener());
    contenPane.setLayout(null);
    label.setSize(100, 100);
    label.setLocation(100, 100);
    contenPane.add(label);
    this.setSize(500, 500);
    this.setVisible(true);
    this.setFocusable(true);
    this.requestFocus();
    contenPane.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e) {
            Container contentPane = (Container) e.getSource;
        }
    });
  }

  class MyKeyListener extends KeyAdepter {

    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (keyCode == KeyEvent.VK_UP) {
        System.out.println("UP");
        label.setLocation(label.getX(), label.getY() - 10);
      } else if(keyCode == KeyEvent.VK_DOWN) {
        System.out.println("Down");
        label.setLocation(label.getX(), label.getY() + 10);
      }
    }
  }
  public static void main(String[] args) {
    new FlyingText();
  }
}
