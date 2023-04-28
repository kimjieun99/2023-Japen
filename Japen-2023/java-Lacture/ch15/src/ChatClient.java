import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame {

  private JTextField sender;
  private Receiver receiver;
  private ServerSocket listener = null;
  private Socket socket = null;

  private BufferedReader in = null;
  private BufferedWriter out = null;

  ChatClient() {
    this.setTitle("채팅 클라이언트");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());

    sender = new JTextField(40);
    receiver = new Receiver();

    sender.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String msg = sender.getText();
          try {
            out.write(msg + "\r\n");
            out.flush();

            out.write("\r\n 클라이언트 : " + msg);
            int end = receiver.getText().length();
            receiver.setCaretPosition(end);
            sender.setText("");
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      }
    );

    contentPane.add(sender, BorderLayout.SOUTH);
    contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);

    this.setSize(400, 500);
    this.setVisible(true);

    try {
      socket = new Socket("192.168.0.31", 9998);
      int end = receiver.getText().length();
      receiver.setCaretPosition(end);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out =
        new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Thread thread = new Thread(receiver);
    thread.start();
  }

  class Receiver extends JTextArea implements Runnable {

    @Override
    public void run() {
      String msg = null;
      while (true) {
        try {
          msg = in.readLine();
        } catch (Exception e) {
          e.printStackTrace();
        }
        this.append("\r\n 클라이언트 : " + msg);
        // 높이 설정
        int end = this.getText().length();
        this.setCaretPosition(end);
      }
    }
  }

  public static void main(String[] args) {
    new ChatClient();
  }
}
