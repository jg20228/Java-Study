package ch14;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventEx106 extends JFrame {
	private JLabel[] keyMessage;

	public EventEx106() {
		setTitle("keyListner 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		
		//레이블 배열을 3개 생성하고 각 레이블 컴포넌트 생성
		keyMessage = new JLabel[3]; //레이블 배열 생성
		keyMessage[0] = new JLabel(" getkeyCode() ");
		keyMessage[1] = new JLabel(" getkeyChar() ");
		keyMessage[2] = new JLabel(" getkeyText() ");
		
		//3개의 레이블 컴포넌트를 컨텐츠팬에 부착
		
		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
				
		}

	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));

			System.out.println("keyPressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped");
		}
	}

	public static void main(String[] args) {
		new EventEx106();
	}

}
