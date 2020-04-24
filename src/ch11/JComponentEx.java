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
	// 모든 Component에서 private로 선언해서 heap에서 관리함(stack에서 관리하면 못찾음)
	private JButton b1, b2, b3;

	public JComponentEx() {
		setTitle("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		b1 = new JButton("Magenta/Yellow Button");
		b2 = new JButton("	Disabled Button	");
		b3 = new JButton("getX(),getY()");
		
		//소문자도 똑같이 가능하지만 final이므로 대문자로 쓴다.
		b1.setBackground(Color.YELLOW); //백그라운드
		b2.setForeground(Color.MAGENTA); //포그라운드
		b3.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false); //버튼 비활성화
		b3.addActionListener(new ActionListener() {
			
			//타켓(콜백되는)
			@Override
			public void actionPerformed(ActionEvent e) {
				//e = 무엇이 클릭되었을지 모름
				//JButton b = (JButton)e.getSource(); //Object를 return하기 때문에 다운캐스팅
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
