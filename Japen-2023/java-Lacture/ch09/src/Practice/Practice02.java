package Practice;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Practice02 extends JFrame {

  public Practice02() {
    setTitle("BorderLayout Practice");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout(5,7));
    contentPane.add(new JButton("North"), BorderLayout.NORTH);
    contentPane.add(new JButton("West"), BorderLayout.WEST);
    contentPane.add(new JButton("Center"), BorderLayout.CENTER);
    contentPane.add(new JButton("East"), BorderLayout.EAST);
    contentPane.add(new JButton("South"), BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    new Practice02();
  }
}
