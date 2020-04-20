import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class FirstApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstApp window = new FirstApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);//위치까지 정해줌
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(12, 210, 96, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setBounds(60, 0, 65, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRead = new JButton("Read");
		btnRead.setBounds(177, 0, 65, 28);
		frame.getContentPane().add(btnRead);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(297, 0, 65, 28);
		frame.getContentPane().add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("Hello");
		lblNewLabel_1.setBounds(118, 102, 37, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Love");
		lblNewLabel_2.setBounds(251, 166, 37, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(0, 0, 434, 41);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
