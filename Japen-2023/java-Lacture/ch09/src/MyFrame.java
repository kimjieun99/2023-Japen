import java.awt.Container;

import javax.swing.*;
//import javax.swing.text.FlowView;

public class MyFrame extends JFrame {

  public MyFrame() {
    setTitle("300 X 300으로 스윙 프레임 만들기");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
    //JFrame은 기본적으로 Container를 하나 들고 있음...
    Container contentPane = getContentPane();
    // contentPane.setLayout(FlowLayout());
    contentPane.add(new JButton("OK"));
    contentPane.add(new JButton("CANCEL"));
    contentPane.add(new JButton("IGNORE"));
    //Conponent는 Container에 포함되어야 한다.
  }

  public static void main(String[] args) {
    //MyFrame myFrame = new MyFrame();
  }
}
