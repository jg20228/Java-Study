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
	// map - 0 = �̵�����, 1 - ball, 2 - goal, 3 - wall
	private JLabel imgHero;
	private int heroX;
	private int heroY;
	private ImageIcon imgHeroU = new ImageIcon("img/heroU.jpg");

	public Test2() {
		Container c = getContentPane();
		// ������ġ
		heroX = 0;
		heroY = 0;

		// swing �⺻����
		setTitle("100px ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		c.setLayout(null);
		// player �ʱ�ȭ
		imgHero = new JLabel(imgHeroU);
		imgHero.setSize(100, 100);
		
		setVisible(true);
		
		
	} 

	public static void main(String[] args) {
		new Test2();

	}
}
