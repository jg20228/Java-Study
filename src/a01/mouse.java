package a01;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class mouse {
	JFrame frame = new JFrame();
	Toolkit tk = Toolkit.getDefaultToolkit();
	//Ŀ�� �̹���
	Cursor invisCursor = tk.createCustomCursor(tk.createImage("img/ball.jpg"),new Point(), null);
	public mouse() {
		frame.setCursor(invisCursor);
		frame.getGlassPane().setVisible(true);
		frame.setTitle("���콺");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new mouse();
	}

}
