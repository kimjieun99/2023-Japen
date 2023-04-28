import java.awt.Container;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerEx extends JFrame {

  private JLabel label = new JLabel("Hello");

  public MouseListenerEx() {
    this.setTitle("Mouse Event 예제");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contenPane = this.getContentPane();
    contenPane.setLayout(null);
    label.setLocation(100, 100);
    label.setSize(50, 20);
    contenPane.add(label);
    contenPane.addMouseListener(new MyMouseListener());
    this.setSize(300, 300);
    this.setVisible(true);
  }
 class MyMouseListener implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Mouse Click Complete");
    int x = e.getX();
    int y = e.getY();
    label.setLocation(x, y);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

 }
  public static void main(String[] args) {
    new MouseListenerEx();
  }
}
