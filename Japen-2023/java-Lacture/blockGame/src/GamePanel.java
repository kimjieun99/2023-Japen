import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  static int GAP = 2;
  public Paddle paddle;
  public boolean isEnd = false;
  public Ball ball;
  public Block blocks[][];
  public Thread th;

  public int score = 0;

  public GamePanel() {
    System.out.println("game panel 생성자");
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(60 * 10 + GAP * 9, 900));
    th = new Thread(this);
    th.start();
    paddle = new Paddle();
    ball = new Ball();
    blocks = new Block[5][10];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 10; j++) {
        blocks[i][j] = new Block();
        blocks[i][j].x = (60 + GAP) * j;
        blocks[i][j].y = (30 + GAP) * i + 50;
        blocks[i][j].width = 60;
        blocks[i][j].height = 30;
        blocks[i][j].color = i;
      }
    }

    this.addKeyListener(
        new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {}

          @Override
          public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
              // System.out.println("왼쪽");
              paddle.isLeft = true;
              paddle.isRight = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
              // System.out.println("오른쪽");
              paddle.isLeft = false;
              paddle.isRight = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE && !ball.isLive) {
              ball.isUp = true;
              ball.isLive = true;
              if (Math.random() > 0.5) {
                ball.isLeft = true;
              } else {
                ball.isRight = true;
              }
            }
            if (e.getKeyCode() == KeyEvent.VK_R && isEnd) {
              paddle = new Paddle();
              ball = new Ball();
              blocks = new Block[5][10];
              for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                  blocks[i][j] = new Block();
                  blocks[i][j].x = (60 + GAP) * j;
                  blocks[i][j].y = (30 + GAP) * i + 50;
                  blocks[i][j].width = 60;
                  blocks[i][j].height = 30;
                  blocks[i][j].color = i;
                }
              }
              score = 0;
              ball.count = 3;
              isEnd = false;
            }
          }

          @Override
          public void keyReleased(KeyEvent e) {
            paddle.isLeft = false;
            paddle.isRight = false;
          }
        }
      );
    this.setFocusable(true);
    this.requestFocus();
  }

  // 볼이 사라지면 패들 가운데로 위치 옮겨지고
  // space 바를 입력받아서 누르면 다시 볼이 움직이기 시작
  // 패들 // 공
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
    g.fillOval(ball.x, ball.y, ball.width, ball.height);
    if (isEnd) {
      g.setColor(Color.BLACK);
      g.drawRect(0, 0, 618, 900);
      g.setColor(Color.WHITE);
      g.setFont(new Font("맑은 고딕", Font.BOLD, 32));
      g.drawString("GAME OVER", 40, 400);
      g.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      g.drawString("PRESS R GAME RESTART", 40, 500);
    } else {
      if (!ball.isHide) {
        g.fillOval(ball.x, ball.y, ball.width, ball.height);
      }
      g.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      g.drawString("SCORE : " + score, 500, 30);
      g.drawString("BALL COUNT : " + ball.count, 40, 30);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 10; j++) {
          if (blocks[i][j].isHide) {
            continue;
          }
          if (blocks[i][j].color == 0) {
            g.setColor(Color.BLUE);
          } else if (blocks[i][j].color == 1) {
            g.setColor(Color.GREEN);
          } else if (blocks[i][j].color == 2) {
            g.setColor(Color.MAGENTA);
          } else if (blocks[i][j].color == 3) {
            g.setColor(Color.YELLOW);
          } else if (blocks[i][j].color == 4) {
            g.setColor(Color.ORANGE);
          }
          g.fillRect(
            blocks[i][j].x,
            blocks[i][j].y,
            blocks[i][j].width,
            blocks[i][j].height
          );
        }
      }
    }
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      repaint();
      ballMove();
      paddleMove();
      checkBlock();
    }
  }

  public void checkBlock() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 10; j++) {
        Block block = blocks[i][j];
        if (!block.isHide) {
          if (ball.isUp) {
            if (
              hitObject(
                new Rectangle(ball.x, ball.y, ball.width, ball.height),
                new Rectangle(block.x, block.y, block.width, block.height)
              )
            ) {
              // System.out.println("충돌");
              block.isHide = true;
              ball.isUp = false;
              ball.isDown = true;
              ball.speed += 1;
              score += 10;
            }
          } else if (ball.isDown) {
            if (
              hitObject(
                new Rectangle(ball.x, ball.y, ball.width, ball.height),
                new Rectangle(block.x, block.y, block.width, block.height)
              )
            ) {
              block.isHide = true;
              ball.isUp = true;
              ball.isDown = false;
              score += 10;
            }
          } else if (ball.isLeft) {
            if (
              hitObject(
                new Rectangle(ball.x, ball.y, ball.width, ball.height),
                new Rectangle(block.x, block.y, block.width, block.height)
              )
            ) {
              // System.out.println("충돌");
              block.isHide = true;
              ball.isRight = true;
              ball.isLeft = false;
              score += 10;
            } else if (ball.isRight) {
              if (
                hitObject(
                  new Rectangle(ball.x, ball.y, ball.width, ball.height),
                  new Rectangle(block.x, block.y, block.width, block.height)
                )
              ) {
                // System.out.println("충돌");
                block.isHide = true;
                ball.isRight = false;
                ball.isLeft = true;
                score += 10;
              }
            }
          }
        }
      }
    }
  }

  public void paddleMove() {
    if (paddle.isLeft) {
      paddle.x -= 10;
      if (paddle.x <= 0) {
        paddle.x = 0;
      }
    } else if (paddle.isRight) {
      paddle.x += 10;
      if (paddle.x + paddle.width >= 618) {
        paddle.x = 618 - paddle.width;
      }
    }
  }

  public void ballMove() {
    // 공의 isLive
    if (ball.isLive) {
      if (ball.x >= 618 - 10) {
        ball.isLeft = true;
        ball.isRight = false;
      } else if (ball.x <= 0) {
        ball.isLeft = false;
        ball.isRight = true;
      }
      if (ball.y >= 890) {
        ball.isUp = true;
        ball.isDown = false;
      } else if (ball.y <= 0) {
        ball.isUp = false;
        ball.isDown = true;
      }

      if (ball.isUp) {
        ball.y -= ball.speed;
      } else if (ball.isDown) {
        ball.y += ball.speed;
        // 여기다가 패들과의 충돌
        if (
          hitObject(
            new Rectangle(ball.x, ball.y, ball.width, ball.height),
            new Rectangle(paddle.x, paddle.y, paddle.width, paddle.height)
          )
        ) {
          ball.isUp = true;
          ball.isDown = false;
        } else {
          if (ball.y > paddle.y + paddle.height) {
            // ball.isHide = true;
            ball.isLeft = false;
            ball.isRight = false;
            ball.isUp = false;
            ball.isDown = false;
            ball.x = paddle.x + paddle.width / 2 - 5;
            ball.y = paddle.y - 10;
            ball.isLive = false;
            ball.count--;
            if (ball.count <= 0) {
              System.out.println("게임 끝");
              isEnd = true;
            }
            // count가 0이 되면 게임 종료 화면 띄우기
            // System.out.println("패들 벗어남");
            // 공이 사라져야 함......
          }
        }
      }

      if (ball.isLeft) {
        ball.x -= ball.speed;
      } else if (ball.isRight) {
        ball.x += ball.speed;
      }
    } else {
      ball.x = paddle.x + paddle.width / 2 - 5;
      ball.y = paddle.y - 10;
    }
  }

  public boolean hitObject(Rectangle ball, Rectangle rect) {
    return ball.intersects(rect);
  }
}
// 공의 갯수를 3개로 3번 빠지면 끝나게 하기
