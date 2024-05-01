package tenco_swing.ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;
	int enemyX = 250;
	int enemyY = 420;
	boolean move = true;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스안에 클래스를 작성하는 문법 --> 중첩 클래스
	// 외부클래스, 내부클래스 관계
	private class ImagePanel extends JPanel implements Runnable {

		// paintComponents --> X
		// paintComponent --> O
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(player1, playerX, playerY, 50, 50, null);
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);
			// Todo 플레이어, 적 그림 그려야 함.
			// 쓰레드를 활용할 예정
		}

		@Override
		public void run() {
			boolean flag = true;
			// true => 왼쪽으로 가기
			// false ==> 오른쪽으로 가기
			while (move) {
				System.out.println("진행중");
				if (flag == true) {
					enemyX -= 10;
				} else {
					enemyX += 10;
				}

				if (enemyX <= 50) {
					flag = false;
				}
				if (enemyX >= 500) {
					flag = true;
				}
				// 방향 바꾸는 개념은 적군 X 좌표값이 50일때 , 550일때로 설정.
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		}
	}

	private void initData() {
		setTitle("Thread 를 활용한 미니 예제");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("images/backgroundMap.png"));
			player1 = ImageIO.read(new File("images/playerL.png"));
			enemy1 = ImageIO.read(new File("images/enemyL.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임시킨다.
		Thread thread = new Thread(imagePanel);
		thread.start();
	}

	private void setInitLayout() {
		// setLayout(null);
		// setResizable(false);
		setVisible(true);

		add(imagePanel);

	}

	private void addEventListener() {
		// 이벤트리스너 등록 방법 2가지 중
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("여기가 동작합니다.");
				int code = e.getKeyCode();
				// 제어문 작성
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					// 1. 스페이스바를 눌렀을 때 적군을 멈출수 있도록 코드 수정
					// 2. 토글 개념으로 스페이스바를 눌렀을 때 다시 진행할 수 있게 코드수정

					if (move == true) {
						try {
							move = false;
							Thread.sleep(999999999);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (move == false) {
						move = true;
						Thread.interrupted();

					}

				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("방울 공격");
				}

				// 3. 플레이어가 적군과 만났다면 플레이어 그림을 없애 주세요.
				repaint();
			} // end of keyPressed
		});

	}

}
