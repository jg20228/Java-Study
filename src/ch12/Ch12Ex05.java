package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ch12Ex05 extends JFrame {
	private MyPanel panel = new MyPanel();

	public Ch12Ex05() {
		setTitle("drawLine ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(null);
		setLocationRelativeTo(null); // �߾�

		setSize(800, 600);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		int min = 1;
		int max = 1;
		String stdYymm = "����"; // ��¥ ����
		int height = 200 * (min / max); // ���� ������ ����

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (int i = 0; i < 10; i++) {
				g.setColor(Color.RED);
				g.fillRect((40 * i) + 20, 500 - height, 20, height); // (x,y,width,height)
				g.drawString(stdYymm + (i + ""), (40 * i) + 20, 520); // (x,y)
			}

		}
	}

	public static void main(String[] args) {
		new Ch12Ex05();
	}

}
