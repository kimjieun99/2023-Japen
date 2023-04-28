package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice01 extends JFrame {

  private JLabel label = new JLabel();

  public Practice01() {
    this.setTitle("마우스 올리고 내리기");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = this.getContentPane();

    contentPane.addMouseListener(new MyMouseListener());
    contentPane.addMouseMotionListener(new MyMouseListener());
    contentPane.setLayout(new FlowLayout());
    contentPane.add(label);

    this.setBackground(Color.LIGHT_GRAY);
    this.setSize(300, 300);
    this.setVisible(true);
  }

  class MyMouseListener implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
      label.setText("사랑해");
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
      label.setText("JAVA LOVE");
    }
  }

  public static void main(String[] args) {
    new Practice01();
  }
}
