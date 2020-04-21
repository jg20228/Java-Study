package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventEx05 extends JFrame {
	private JLabel la;

	public EventEx05() {
		la = new JLabel("Hello");
		setTitle("MouseEvent ����");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �̺�Ʈ �й� ������ ����
		Container c = getContentPane();

		c.addMouseListener(new MyMouseListener());
		c.setLayout(null); // absoulte ���̾ƿ�
		la.setSize(50, 20); // ���� ������
		la.setLocation(30, 30); // ���� ��ġ
		c.add(la);

		setSize(250, 250);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		// Adapter�� �̿��ϸ� �������� ��� ã�Ƽ� �����
		// ���콺�� Ŭ���ϰ� ���� ��....
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // X ��ǥ
			int y = e.getY(); // Y ��ǥ
			la.setLocation(x, y); // �� ��ġ ���� = repaint()
			new Thread(new Runnable() {
				@Override
				public void run() {
					int y = e.getY();
					int targetY = e.getY() + 50;
					while (y < 195 && targetY > y) {
						try {
							Thread.sleep(50);
							y = y + 2;
							la.setLocation(x, y);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

//			while(true) {
//				if(y>220) break;
//				y = y + 3;
//				try {
//					Timer time = new Timer();
//					time.wait(1);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//				la.setLocation(x, y);
//			}
		}
	}

	public static void main(String[] args) {
		new EventEx05();
	}
}
