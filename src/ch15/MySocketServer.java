package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket; // 연결을 요청받는애
	Socket socket;
	BufferedReader br;

	public MySocketServer() throws Exception {//나를 호출한애한테 오류를 던짐
		serverSocket = new ServerSocket(15000); // 서버 소켓 생성(연결을 받는)
		// 새로운 소켓을 생성해서 요청을 대기함
		socket = serverSocket.accept(); // 요청을 대기 - 내부에서 일정시간마다 false, true를 반환
		System.out.println(socket.getInetAddress()+" 요청이 들어옴");
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = "";

		while ((msg = br.readLine()) != null) {
			System.out.println("상대방(sender) : " + msg);
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
