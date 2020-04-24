package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame {
	// ��� Component���� private�� �����ؼ� heap���� ������(stack���� �����ϸ� ��ã��)
	private JButton b1, b2, b3;

	public JComponentEx() {
		setTitle("JComponent�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		b1 = new JButton("Magenta/Yellow Button");
		b2 = new JButton("	Disabled Button	");
		b3 = new JButton("getX(),getY()");
		
		//�ҹ��ڵ� �Ȱ��� ���������� final�̹Ƿ� �빮�ڷ� ����.
		b1.setBackground(Color.YELLOW); //��׶���
		b2.setForeground(Color.MAGENTA); //���׶���
		b3.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false); //��ư ��Ȱ��ȭ
		b3.addActionListener(new ActionListener() {
			
			//Ÿ��(�ݹ�Ǵ�)
			@Override
			public void actionPerformed(ActionEvent e) {
				//e = ������ Ŭ���Ǿ����� ��
				//JButton b = (JButton)e.getSource(); //Object�� return�ϱ� ������ �ٿ�ĳ����
				b3.setText("Hello");
			}
		});
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new JComponentEx();
	}
}
