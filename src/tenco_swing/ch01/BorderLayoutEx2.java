package tenco_swing.ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx2 extends JFrame {

	final int width = 600;
	final int height = 600;
	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	public BorderLayoutEx2() {

		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[5];
	}

	public void setInitLayout() {
		// 배치 관리자 선정
		// BorderLayout -- 컴포넌트들을 동,서,남,북,가운데 로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		for (int j = 0; j < buttons.length; j++) {
			add(new JButton(directions[j]), directions[j]);
		}
	}

	// 코드 테스트

	public static void main(String[] args) {

		new BorderLayoutEx2();
	}// end of main

}// end of class
