package chat;

//Ctrl + Shift + O - 안쓰는 임포트 삭제
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {

	ServerSocket serverSocket;
	Vector<NewSocketThread> vt; // List에 자식이라고
	// ArrayList - 동시에 접근할때 도중에 데이터 변경되면 꼬일수있음
	// Vector - 동시접근을 막을때 사용(큐에 대기하고 있음) - 꼭필요할때만 Vector

	public MySocketServer() throws Exception {
		vt = new Vector<>(); // 만들어진 소켓 담기 (br, bw에만 연결하면 되어서 클래스를 담음)
		serverSocket = new ServerSocket(3000);

		while (true) {
			Socket socket = serverSocket.accept(); // 보관할 컬렉션 필요 - Vector<NewSocketThread> vt;
			//System.out.println("요청이 들어옴");
			NewSocketThread nt = new NewSocketThread(socket);// 새로운 스레드에 socket을 넘김
			Thread newWorker = new Thread(nt);
			newWorker.start();
			vt.add(nt);
		}
	}

	// 새로운 쓰레드에게 버퍼를 연결할 수 있게 socket을 전달!!
	class NewSocketThread implements Runnable { // 내부 클래스
		Socket socket;
		BufferedReader br;
		BufferedWriter bw;

		public NewSocketThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				String msg = "";
				while ((msg = br.readLine()) != null) {
					System.out.println("클라이언트 : "+msg);
					for (NewSocketThread newSocketThread : vt) {
						if (newSocketThread != this) {
							newSocketThread.bw.write(msg + "\n");
							newSocketThread.bw.flush();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		try {
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
