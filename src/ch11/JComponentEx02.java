package ch11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx02 extends JFrame implements ActionListener {
	private JButton b1, b2, b3;

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ȭ���� ���� ��Ʈ��������, ������Ʈ������ ������
		JButton b = (JButton) e.getSource();// Ŭ���� ��ư�� �𸶼���.(������Ʈ�� ������) , IPC(�ȵ���̵忡�� ���̾�)
		if(((JButton) e.getSource())==b1) {
			System.out.println("���");
		}
		b.setText("text");
	}

	public JComponentEx02() {
		setTitle("JComponent�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		b1 = new JButton("b1");
		b2 = new JButton("b2");
		b3 = new JButton("b3");

		b1.addActionListener(this); // this :JComponentEx02 , target : actionPerformed
		b2.addActionListener(this);
		b3.addActionListener(this);

		c.add(b1);
		c.add(b2);
		c.add(b3);

		setSize(260, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new JComponentEx02();
	}
}
