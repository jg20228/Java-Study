package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket; // ������ ��û�޴¾�
	Socket socket;
	BufferedReader br;

	public MySocketServer() throws Exception {//���� ȣ���Ѿ����� ������ ����
		serverSocket = new ServerSocket(15000); // ���� ���� ����(������ �޴�)
		// ���ο� ������ �����ؼ� ��û�� �����
		socket = serverSocket.accept(); // ��û�� ��� - ���ο��� �����ð����� false, true�� ��ȯ
		System.out.println(socket.getInetAddress()+" ��û�� ����");
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = "";

		while ((msg = br.readLine()) != null) {
			System.out.println("����(sender) : " + msg);
		}
		
		br.close();
		socket.close();
		serverSocket.close();

	}

	public static void main(String[] args) {
		try {
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
