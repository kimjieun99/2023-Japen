import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioBoxEx extends JFrame {
    private JCheckBox fruits[] = new JRadioButton[3];
    private sumLabel = new JLabel("합계 : 0");
    
    public JRadioBoxEx() {  JLabel title = 
        new JLabel("사과 1000, 딸기 8000, 체리 10000");
        // JCheckBox check01 = new JCheckBox("사과");
        // JCheckBox check02 = new JCheckBox("딸기", true);
        // JCheckBox check03 = new JCheckBox("체리");
        for(int i=0;i<3;i++) {
            fruits[i] = new JCheckBox(fruitName[i]);
            contentPane.add(fruits[i]);
            fruits[i].addItemListener();
        }
        contentPane.add(sumLabel);
        class MyItemListener implements ItemListener {
            ButtonGroup btnGroup = new ButtonGroup();
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    if(e.getItem()==fruits[0]) {
                }else if(e.getItem()==fruits[1]){
                    sum+=8000;
                }else if(e.getItem()==fruits[2]){
                    sum+=10000;}
                }     
            }

        }
        
        contentPane.add(btnGroup);
        contentPane.add(sumLabel);


        class MyItemListener implements ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    if(e.getItem()==fruits[0]) {

                }else if(e.getItem()==fruits[1]){
                 
                }else if(e.getItem()==fruits[2]){
                    }
                }     
            }


        }


        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        

        contentPane.add(check01);
        contentPane.add(check02);

        this.setSize(300, 300);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new JRadioBoxEx();
    }
}