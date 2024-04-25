package tenco_swing.ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼 ,라벨) 등을 수평 , 수직으로 배치를 해주는 클래스이다.
public class FlowLayoutEx extends JFrame {

	// 배열 활용
	
	private JButton button[] = new JButton[6];

	
	// 생성자
	public FlowLayoutEx() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();
	}
	
	
	// 멤버 변수를 초기화 하는 기능(값을 넣다)
	public void initData() {
		for (int i = 0; i<button.length; i++) {
			button[i] = new JButton("button"+ (i+1));			
		}
	}
	
	// 컴포넌트들을 배치하는 기능 
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치 관리자가 기본으로 활용된다.
		//FlowLayout flowLayout = new FlowLayout(); 
		//new FlowLayout(); // 배치 관리자 --> FlowLayout
		
		//==
		// 배치 관리자 생성 및 JFrame 세팅	
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));
		
		// 컴포넌트들을 붙이다.
		// 반복문 활용
		for(int j = 0; j<button.length; j++) {
			super.add(button[j]);			
		}
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		new FlowLayoutEx();	// < --- 주소값이 없는 상태 (익명 클래스)
		// FlowLayoutEx f1 = new FlowLayoutEx();	// < --- 부를수 있는 상태
		// 다시 접근해서 사용할 일이 없으면 new라고 선언만 해도 상관없음.
		
		
	}// end of main
}// end of clss


