import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerEx02 extends JFrame {

  private JLabel label = new JLabel();

  private JLabel[] keyMessage;

  public KeyListenerEx02() {
    this.setTitle("KeyListener");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contenPane = this.getContentPane();
    contenPane.setLayout(new FlowLayout());
    contenPane.addKeyListener()=(new MyKeyListener());
    contenPane.add(label);
    this.setSize(300, 300);
    this.setVisible(true);
    contenPane.setFocusable(true);
    contenPane.requestFocus();
  }

  class MyKeyListener extends KeyAdepter {

    public void keyPressed(KeyEvent e) {
      Container contentPane = (Container) e.getSource();
      int keyCode = e.getKeyCode();
      char keyChar = e.getKeyChar();
      if (keyCode == KeyEvent.VK_F1) {
        contentPane.setBackground(Color.GREEN);
      } else if (keyCode == KeyEvent.VK_F2) {
        contentPane.setBackground(Color.YELLOW);
      }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
  }

  public static void main(String[] args) {
    new KeyListenerEx02();
  }
}
