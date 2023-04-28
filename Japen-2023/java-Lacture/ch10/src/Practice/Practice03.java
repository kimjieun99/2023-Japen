package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice03 extends JFrame {

  public Practice03() {
    this.setTitle("Left 키로 문자열 교체");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    // contentPane.addMouseListener(new MyMouseListener());
    // contentPane.addMouseMotionListener(new MyMouseListener());
    // contentPane.add(label);
    contentPane.setLayout(new FlowLayout());
    JLabel label = new JLabel("LOVE JAVA");
    label.addKeyListener(
      new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("키 눌렸음.");
            JLabel label = (JLabel) e.getSource();
            StringBuffer sb = new StringBuffer(label.getText());
            label.setText(sb.reverse().toString());
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

//   class MyMouseListener implements MouseListener, MouseMotionListener {

//     @Override
//     public void mouseClicked(MouseEvent e) {}

//     @Override
//     public void mouseEntered(MouseEvent e) {}

//     @Override
//     public void mouseExited(MouseEvent e) {}

//     @Override
//     public void mousePressed(MouseEvent e) {}

//     @Override
//     public void mouseReleased(MouseEvent e) {}

//     @Override
//     public void mouseDragged(MouseEvent e) {}

//     @Override
//     public void mouseMoved(MouseEvent e) {}
//   }

  public static void main(String[] args) {
    new Practice03();
  }
}
