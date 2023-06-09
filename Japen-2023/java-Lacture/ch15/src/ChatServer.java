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
    this.setTitle("채팅 서버");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBackground(Color.LIGHT_GRAY);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());

    sender = new JTextField(40);

    sender.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String msg = sender.getText();
          try {
            out.write(msg + "\r\n");
            out.flush();

            out.write("\r\n 서버 : " + msg);
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

    this.setSize(400, 500);
    this.setVisible(true);

    try {
      listener = new ServerSocket(9998);
      socket = listener.accept(); // 서버에 붙는 애들
      receiver.append("클라이언트 연결 완료");
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
        this.append("\r\n 서버 : " + msg);
        // 높이 설정
        int end = this.getText().length();
        this.setCaretPosition(end);
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer();
  }
}
