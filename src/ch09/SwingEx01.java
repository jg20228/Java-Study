package ch09;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame {

	public SwingEx01() {
		//JFrame�� �⺻ �гο� �����ϱ�
		Container contentPane = getContentPane();
		//JFrame�� �⺻ �г��� BorderLayout-> FlowLayout ����
		contentPane.add(new JButton("ù��° ��ư"));
		//�⺻ �гο� ��ư �׸���
		contentPane.setLayout(new FlowLayout());
		//���� �׸���
		setTitle("300x300 ���� ������ �����");
		//ũ�� 300,300���� �׸���
		setSize(300, 300);
		setVisible(true);// painting (�̶� �׸��� �׷���)
	}

	public static void main(String[] args) {
		new SwingEx01();
	}

}
