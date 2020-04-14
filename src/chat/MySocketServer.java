package chat;

//Ctrl + Shift + O - �Ⱦ��� ����Ʈ ����
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {

	ServerSocket serverSocket;
	Vector<NewSocketThread> vt; // List�� �ڽ��̶��
	// ArrayList - ���ÿ� �����Ҷ� ���߿� ������ ����Ǹ� ���ϼ�����
	// Vector - ���������� ������ ���(ť�� ����ϰ� ����) - ���ʿ��Ҷ��� Vector

	public MySocketServer() throws Exception {
		vt = new Vector<>(); // ������� ���� ��� (br, bw���� �����ϸ� �Ǿ Ŭ������ ����)
		serverSocket = new ServerSocket(3000);

		while (true) {
			Socket socket = serverSocket.accept(); // ������ �÷��� �ʿ� - Vector<NewSocketThread> vt;
			//System.out.println("��û�� ����");
			NewSocketThread nt = new NewSocketThread(socket);// ���ο� �����忡 socket�� �ѱ�
			Thread newWorker = new Thread(nt);
			newWorker.start();
			vt.add(nt);
		}
	}

	// ���ο� �����忡�� ���۸� ������ �� �ְ� socket�� ����!!
	class NewSocketThread implements Runnable { // ���� Ŭ����
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
					System.out.println("Ŭ���̾�Ʈ : "+msg);
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
