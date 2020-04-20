package ch09;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//533p 7번

public class GridLayoutPrac2 extends JFrame {

	public GridLayoutPrac2() {
		setTitle("Prac2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new JLabel("수식입력 "), BorderLayout.NORTH);
		c.add(new JTextField(""),BorderLayout.NORTH);
		setBounds(200, 200, 400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutPrac2();
	}
}
