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
		// 직렬화같은 경우는 스트링까지만, 오브젝트까지는 마샬링
		JButton b = (JButton) e.getSource();// 클릭된 버튼을 언마샬링.(오브젝트를 던져줌) , IPC(안드로이드에서 많이씀)
		if(((JButton) e.getSource())==b1) {
			System.out.println("출력");
		}
		b.setText("text");
	}

	public JComponentEx02() {
		setTitle("JComponent의 공통 메소드 예제");
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
