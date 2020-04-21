package ch14;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventExOpenChallenge extends JFrame {
	private JLabel[] keyMessage;

	public EventExOpenChallenge() {
		setLocationRelativeTo(null);

		keyMessage = new JLabel[3]; // 레이블 배열 생성
		keyMessage[0] = new JLabel("0");
		keyMessage[1] = new JLabel("0");
		keyMessage[2] = new JLabel("0");
		JLabel la = new JLabel("시작합니다.");

		setTitle("OpenChallenge");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT,120,40));
		c.setFocusable(true);
		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setFont(new Font("돋움", Font.PLAIN, 50));
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.MAGENTA);
		}
		
		c.add(la);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					for (int i = 0; i < keyMessage.length; i++) {
						int x = (int)(Math.random()*5);
						keyMessage[i].setText(x+"");
						System.out.println(keyMessage[i].getText());
					}
					if(keyMessage[0].getText().equals(keyMessage[1].getText()) && keyMessage[1].getText().equals(keyMessage[2].getText())){
						la.setText("축하합니다");
					}else la.setText("아쉽군요");

				}
			}
		});
		setVisible(true);

	}

	public static void main(String[] args) {
		new EventExOpenChallenge();
	}

}
