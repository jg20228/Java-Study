package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame {
	private JTextField tf;
	private JTextArea ta;
	private ScrollPane sp; // �ٸ� ��ũ�ѵ� ����
	
	public TextFieldEx() {
		init();
		setTitle("�ؽ�Ʈ�ʵ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		// TextField ���� �����ϴ� 2���� ���
		// 1.Font
		tf.setFont(new Font("Arial", Font.BOLD, 30));
		// 2.PreferredSize�� Dimension - ��� Component�� ���̴� �̰ɷ� ����
		tf.setPreferredSize(new Dimension(100, 100));

		
		//������ �߿��� 'sp'
		ta.setBackground(Color.YELLOW);
		ta.setFont(new Font("Arial", Font.BOLD, 30));
		ta.setForeground(Color.RED);
		//!
		sp.add(ta);
		// ta.setEnabled(false);

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String value = tf.getText();
					ta.append(value + "\n");
					tf.setText("");
				}
			}
		});
		c.add(tf, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);

		setSize(400, 500);
		setVisible(true);
		
	}
	
	private void init() {
		tf = new JTextField("", 20);
		sp = new ScrollPane();
		ta = new JTextArea("", 5, 20);
	}
	
	
	public static void main(String[] args) {
		new TextFieldEx();
	}

}
