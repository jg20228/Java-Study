package ch09;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton extends JButton {

}

public class SwingEx01 extends JFrame {
	public SwingEx01() {
		setTitle("ù��° ������1");
		setSize(500, 300);
		add(new JButton("Ŭ��"));
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingEx01();
	}
}
