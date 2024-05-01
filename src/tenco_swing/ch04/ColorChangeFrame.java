package tenco_swing.ch04;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
// 이벤트 리스너를 사용하는 방법
// implements ActionListener --> 운영체제가 제어하는 이벤트를 등록할 수 있다.
public class ColorChangeFrame extends JFrame implements ActionListener{
	
	// 이벤트 리스너에 대한 개념을 이해하자
	private JButton button1;
	
	public ColorChangeFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}
	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(button1);
		setVisible(true);
	}
	private void addEventListener() {
		// 버튼1이 눌러지는지 계속 이벤트를 지켜 보라는 코드
		// 이벤트 등록
		button1.addActionListener(this);
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame();
	}//end of main
	
	// 추상 메서드 오버라이드
	// 이벤트가 발생하면 이 메서드를 수행하도록 약속 되어 있음
	// 단, 어떤 컴포넌트가 이벤트가 할당 되었는지 등록을 먼저 해주어야 함.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed 메서드 호출()");
		System.out.println(e.toString());
		button1.setBackground(Color.black);
	}
}// end of class
