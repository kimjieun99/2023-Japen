package Practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Practice09 extends JFrame {

  JPanel fights = new JPanel(); // 결과 보여주는 패널
  JPanel options = new JPanel(); // 3개 나열하는 패널
  JLabel imgLabel[] = new JLabel[3];

  String gameImages[] = {
    "images/rock.png",
    "images/paper.png",
    "images/scissors.png",
  };
  String judgeMsg[] = { "Me!!!", "Computer!!!", "Same!!!" };
  JLabel mine;
  JLabel computer;
  JLabel judge;

  ImageIcon mineImg;
  ImageIcon computerImg;

  public Practice09() {
    this.setTitle("가위가위보");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(options, BorderLayout.NORTH);
    contentPane.add(fights, BorderLayout.CENTER);

    for (int i = 0; i < 3; i++) {
      imgLabel[i] = new JLabel(new ImageIcon(gameImages[i]));
      options.add(imgLabel[i]);
      imgLabel[i].addMouseListener(new MyMouseListener());
    }
    mineImg = new ImageIcon(gameImages[0]);
    computerImg = new ImageIcon(gameImages[0]);
    mine = new JLabel(mineImg);
    computer = new JLabel(computerImg);
    judge = new JLabel("Start");

    

    this.setSize(800, 600);
    this.setVisible(true);
  }

  class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      JLabel jLabel = (JLabel) e.getSource();
      int randomNum = (int) (Math.random() * 3);
      computerImg = new ImageIcon(gameImages[randomNum]);
      computer.setIcon(computerImg);
      if (jLabel == imgLabel[0]) {
        //바위 눌렸을 때
        mineImg = new ImageIcon(gameImages[0]);
        mine.setIcon(mineImg);
        if (randomNum == 0) {
          judge.setText(judgeMsg[2]);
        } else if (randomNum == 1) {
          judge.setText(judgeMsg[1]);
        } else {
          judge.setText(judgeMsg[0]);
        }
      } else if (jLabel == imgLabel[1]) {
        mineImg = new ImageIcon(gameImages[1]);
        mine.setIcon(mineImg);
        if (randomNum == 0) {
          judge.setText(judgeMsg[0]);
        } else if (randomNum == 1) {
          judge.setText(judgeMsg[2]);
        } else {
          judge.setText(judgeMsg[1]);
        }
      } else {
        mineImg = new ImageIcon(gameImages[2]);
        mine.setIcon(mineImg);
        if (randomNum == 0) {
          judge.setText(judgeMsg[1]);
        } else if (randomNum == 1) {
          judge.setText(judgeMsg[0]);
        } else {
          judge.setText(judgeMsg[2]);
        }
      }
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

    }

    @Override
    public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub

    }
  }

  public static void main(String[] args) {
    new Practice09();
  }
}