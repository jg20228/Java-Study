package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {	
		JButton b =  (JButton) e.getSource();
		if (b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}

}

public class EventEx01 extends JFrame {

	public EventEx01() {
		setTitle("Action 이벤트 리스너 예제");
		// X버튼 클릭시 이벤트 분배 스레드 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action");

		// 리스너 생성
		btn.addActionListener(new MyActionListener()); // 이벤트 리스너 달기

		c.add(btn);
		setSize(350, 150);
		setVisible(true);

//		btn.addActionListener(new ActionListener() {
//			// 타겟(이벤트 분배 스레드가 콜백)
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭됨");
//				// e 는 context(이벤트 객체), e.getSource() = 이벤트 소스
//
//				// 마샬링
//				JButton b = (JButton) e.getSource();
//				System.out.println(b.getText());
//				b.setText("액션"); // repaint()
//			}
//		});

		// 리스너 공부
	}

	public static void main(String[] args) {
		new EventEx01();
	}

}
