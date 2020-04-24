package project;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class TestEx01 extends JFrame {

	public TestEx01() {
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

					toSend(phoneNumber, text);
				}
			}
		});

		c.add(btn1);
		c.add(btn2);

		setSize(400, 400);
		setVisible(true);

	}

	public void toSend(String phoneNumber, String text) {
		System.out.println(phoneNumber+text);
		String api_key = "";
		String api_secret = "";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "00000000000");
		params.put("type", "SMS");
		params.put("text", text);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}

	public static void main(String[] args) {
		new TestEx01();
	}

}
