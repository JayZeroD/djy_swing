package tenco_swing.ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame {

	private JLabel jPlayer;
	private JLabel backgroundMap;
	
	
	private int jPlayerx = 100;
	private int jPlayery = 100;
	private final int MOVDE_DISTANCE = 50;
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 1000;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	private final int BACKGROUND_WIDTH = 0;
	private final int BACKGROUND_HEIGHT = 0;

	public MiniGame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setTitle("보글보글");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon2 = new ImageIcon("images/playerL.png");  
		jPlayer = new JLabel(icon2);
		// 좌표기반으로 바꾼다면 크기와 위치가 모두 있어야 재대로 나온다.
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		Icon icon = new ImageIcon("images/backgroundMap.png");  
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(1000, 600);
		
		
		
		
	}

	public void setInitLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(jPlayerx, jPlayery);
		add(backgroundMap);
		backgroundMap.setLocation(BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
		setVisible(true);

	}

	public void addEventListener() {
		// jPlayer 객체에게만 KeyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의 할 수 있다.
		// jPlayer.addKeyListener(this);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("위");
					jPlayery -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("왼쪽");
					jPlayerx -= MOVDE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("오른쪽");
					jPlayerx += MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("아래");
					jPlayery += MOVDE_DISTANCE;
				}
				jPlayer.setLocation(jPlayerx, jPlayery);
			}
		});
	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame3();
	}// end of main
}
