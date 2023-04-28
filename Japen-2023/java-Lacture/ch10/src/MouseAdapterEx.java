import java.awt.Container;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAdapterEx extends JFrame{
    private JLabel label = new JLabel("Hello");

    public MouseAdapterEx() {
        this.setTitle("MouseAdepter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenPane = this.getContentPane();
        contenPane.setLayout(null);
        label.setLocation(100, 100);
        label.setSize(50, 20);
        contenPane.add(label);
        this.setSize(300, 300);
        this.setVisible(true);
    }
    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println("MouseAdepter로 연결");
            int x = e.getX();
            int y = e.getY();
            label.setLocation(x, y);
            
        }
    }

    public static void main(String[] args) {
        new MouseAdapterEx();
    }
}
