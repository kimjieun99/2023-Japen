package Practice;

import java.awt.*;
import javax.swing.*;

public class Practice08 extends JFrame {

  public Practice08() {
    setTitle("여러 개의 패널을 가진 프레임");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    StarPanel starPanel = new StarPanel();

    JPanel northPanel = new JPanel();
    northPanel.setLayout(new FlowLayout());
    northPanel.setBackground(Color.LIGHT_GRAY);
    northPanel.add(new JButton("열기"));
    northPanel.add(new JButton("닫기"));
    northPanel.add(new JButton("나가기"));

    JPanel centerPanel = new JPanel();

    JPanel southPanel = new JPanel();
    southPanel.setLayout(new FlowLayout());
    southPanel.setBackground(Color.YELLOW);
    southPanel.add(new JLabel("Word Input"));
    southPanel.add(new JTextField(16));

    contentPane.add(northPanel, BorderLayout.NORTH);
    contentPane.add(centerPanel, BorderLayout.CENTER);
    contentPane.add(southPanel, BorderLayout.SOUTH);

    setSize(300, 300);
    setVisible(true);
  }

  class StarPanel extends JPanel {

    public StarPanel() {
      this.setLayout(new FlowLayout());
      this.setBackground(Color.WHITE);
      for (int i = 0; i < 10; i++) {
        JLabel label = new JLabel("*");
        label.setForeground(Color.RED);
        label.setSize(20, 20);
        int x = (int) (Math.random() * 150 + 50);
        int y = (int) (Math.random() * 150 + 50);
        label.setLocation(x, y);
        this.add(label);
      }
    }
  }

  public static void main(String[] args) {

    new Practice08();
  }
}
