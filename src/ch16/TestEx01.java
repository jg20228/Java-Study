package ch16;

class MyConnection {
}

class MyJDBC extends MyConnection {
	static MyConnection conn;
	public MyJDBC() {
		System.out.println("������ ȣ��");
	}
	// new�Ҷ� static ���ΰ� ȣ���. (ex init)
	static {
		conn = new MyJDBC();
	}
}

class Hello{
	public void play() {
		//RDBMS�� �����Ҷ� Stream�� �ϳ��ε� ��� new�ϸ� �ȵ�
		MyConnection conn = MyJDBC.conn;
	}
}

public class TestEx01 {
	public static void main(String[] args) {
		// MyJDBC mj = new MyJDBC();
		try {
			// Ŭ���� �ε��Ҷ� ���
			// static - ���������� Ȱ�밡��
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
