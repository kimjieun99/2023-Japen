package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Practice02 extends JFrame {

  public Practice02() {
    this.setTitle("드래깅동안 YELLOW");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = this.getContentPane();
    contentPane.addMouseListener(new MyMouseListener());
    contentPane.addMouseMotionListener(new MyMouseListener());
    contentPane.setLayout(new FlowLayout());
    contentPane.setBackground(Color.GREEN);

    this.setSize(300, 300);
    this.setVisible(true);
  }

  class MyMouseListener implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
      Container contentPane = (Container) e.getSource();
      contentPane.setBackground(Color.GREEN);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      Container contentPane = (Container) e.getSource();
      contentPane.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
  }

  public static void main(String[] args) {
    new Practice02();
  }
}
