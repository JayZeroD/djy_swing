package tenco_swing.ch04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.red);
		panel2.setSize(1000, 500);
	}

	private void setInitLayout() {
		add(panel1, BorderLayout.SOUTH);
		add(panel2, FlowLayout.CENTER);
		panel1.add(button1, FlowLayout.LEFT);
		panel1.add(button2, FlowLayout.CENTER);
		panel1.add(button3, FlowLayout.RIGHT);
		setVisible(true);
		
	}

	// 이 메서드의 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().toString().equals(button1.toString())) {
			System.out.println("button1 객체가 눌러졌다고 판명 가능");
			panel2.setBackground(Color.black);
		}
		if (e.getSource().toString().equals(button2.toString())) {
			System.out.println("button2 객체가 눌러졌다고 판명 가능");
			panel2.setBackground(Color.green);
		}
		if (e.getSource().toString().equals(button3.toString())) {
			System.out.println("button3 객체가 눌러졌다고 판명 가능");
			panel2.setBackground(Color.BLUE);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

}
