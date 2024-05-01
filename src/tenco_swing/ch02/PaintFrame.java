package tenco_swing.ch02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tenco_swing.ch02.MyDrawFrame.MyDrawPanel;


public class PaintFrame extends JFrame {

	
	MyPaintFrame myPaintFrame;
	private JPanel panel1;

	public PaintFrame() {

		initData();
		setInitLayout();
	}
	
	
	
	private void initData() {
		setTitle("오목 한판 두실래");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myPaintFrame = new MyPaintFrame();
	}

	private void setInitLayout() {

		add(myPaintFrame);
		setVisible(true);
	}

	
	class MyPaintFrame extends JPanel {

	
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int [] arr1 = new int[50]; 
			for (int i = 0; i < (50*arr1.length); i+=50) {
				g.drawLine(i, 0, i, 2000);
			}
			for (int j = 0; j < (50*arr1.length); j+=50) {
				g.drawLine(0, j, 4000, j);				
			}
			g.drawRoundRect(475, 475, 50, 50, 200, 200);
			g.fillRoundRect(525, 475, 50, 50, 200, 200);
			g.drawRoundRect(525, 525, 50, 50, 200, 200);
			g.fillRoundRect(575, 475, 50, 50, 200, 200);			
			g.drawRoundRect(575, 575, 50, 50, 200, 200);
			g.fillRoundRect(425, 425, 50, 50, 200, 200);	
			//drawRoundRect()는 6 개의 인수를 받습니다. 
			// 처음 두 개는 x 및 y 좌표이고 다음 두 개는 너비와 높이를, 
			// 마지막 두 인수는 호의 너비와 높이입니다. 
		}

	}// end of inner class

}// end of outer class
