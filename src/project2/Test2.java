package project2;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test2 extends JFrame {
	// map - 0 = 이동가능, 1 - ball, 2 - goal, 3 - wall
	private JLabel imgHero;
	private int heroX;
	private int heroY;
	private ImageIcon imgHeroU = new ImageIcon("img/heroU.jpg");

	public Test2() {
		Container c = getContentPane();
		// 시작위치
		heroX = 0;
		heroY = 0;

		// swing 기본설정
		setTitle("100px 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		c.setLayout(null);
		// player 초기화
		imgHero = new JLabel(imgHeroU);
		imgHero.setSize(100, 100);
		
		setVisible(true);
		
		
	} 

	public static void main(String[] args) {
		new Test2();

	}
}
