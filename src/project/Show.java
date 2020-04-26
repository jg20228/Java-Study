package project;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Show extends JFrame {
	public Show() {
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel la1 = new JLabel("to");
		la1.setSize(20, 20);
		la1.setLocation(30, 50);

		JTextArea ta1 = new JTextArea("폰번호 입력.");
		ta1.setSize(100, 20);
		ta1.setLocation(80, 50);

		JLabel la2 = new JLabel("Text");
		la2.setSize(50, 20);
		la2.setLocation(30, 100);

		JTextArea ta2 = new JTextArea("입력.");
		ta2.setSize(200, 100);
		ta2.setLocation(80, 100);

		c.add(la1);
		c.add(ta1);
		c.add(la2);
		c.add(ta2);

		JButton btn1 = new JButton("clear");
		btn1.setSize(100, 30);
		btn1.setLocation(250, 250);
		JButton btn2 = new JButton("send");
		btn2.setSize(100, 30);
		btn2.setLocation(250, 300);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta1.setText("");
				ta2.setText("");
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNumber = ta1.getText();
				String text = ta2.getText();
				if (phoneNumber.length() == 11) {
					new Send().toSend(phoneNumber, text);
					// toSend(phoneNumber, text);
				}else {
					System.out.println("입력을 확인해주세요.");
				}
			}
		});

		c.add(btn1);
		c.add(btn2);

		setSize(400, 400);
		setVisible(true);
	}
}
