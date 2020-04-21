package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx00 extends JFrame {
	// �͸� Ŭ����
	public EventEx00() {
		setTitle("�͸� Ŭ����");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action");
		
		c.add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ȳ�");
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx00();
	}
}
