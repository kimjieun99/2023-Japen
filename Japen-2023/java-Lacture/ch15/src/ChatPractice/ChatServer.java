package ChatPractice;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
 import javax.swing.*;

public class ChatServer extends JFrame {

  private JTextField sender;
  private Receiver receiver;
  private ServerSocket listener = null;
  private Socket socket = null;

  private BufferedReader in = null;
  private BufferedWriter out = null;

  ChatServer() {
    this.setTitle("Chat Server");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());

    //sender

    sender = new JTextField(40);

    sender.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String msg = sender.getText();
          try {
            out.write(msg + "\r\n");
            out.flush();

            out.write("\r\n Sever : " + msg);
            int end = receiver.getText().length();
            receiver.setCaretPosition(end);
            sender.setText("");
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      }
    );

    receiver = new Receiver();

    contentPane.add(sender, BorderLayout.SOUTH);
    contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);

    this.setSize(400, 600);
    this.setVisible(true);

    try {
        listener = new ServerSocket(9998);
        socket = listener.accept();
        receiver.append("Client 연결 완료");
    } catch (Exception e) {}
    //sender
  }

  public static void main(String[] args) {
    new ChatServer();
  }
}
