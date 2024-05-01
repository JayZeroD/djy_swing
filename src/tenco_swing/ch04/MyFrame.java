package tenco_swing.ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * JLabel 을 통해 이미지를 다룰 수 있다.
 * JLabel.add(); 메서드를 통해서 이미지를 겹칠 수 있다
 * 좌표 기준으로 이미지를 세팅 하려면
 * 배치 관리자를 null 값으로 세팅 하여야 한다.
 */

public class MyFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;

	public MyFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JLabel을 활용한 이미지 사용 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/destiny2.jpg"); // 업 캐스팅 상태
		backgroundMap = new JLabel(icon);

		backgroundMap.setSize(2000, 1000);
		backgroundMap.setLocation(0, 0);
		
		player = new JLabel(new ImageIcon("images/cat.png"));
		player.setSize(100,100);
		player.setLocation(100, 100);
	}

	private void setInitLayout() {
		// 좌표값으로 세팅하기 위해서는 배치 관리자를 null 값으로
		// 만들어줘야 한다. 기본값이 border layout이기 때문
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
		
	}

}
