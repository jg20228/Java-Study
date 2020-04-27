package ch16;

class MyConnection {
}

class MyJDBC extends MyConnection {
	static MyConnection conn;
	public MyJDBC() {
		System.out.println("생성자 호출");
	}
	// new할때 static 내부가 호출됨. (ex init)
	static {
		conn = new MyJDBC();
	}
}

class Hello{
	public void play() {
		//RDBMS에 접근할때 Stream은 하나인데 계속 new하면 안됨
		MyConnection conn = MyJDBC.conn;
	}
}

public class TestEx01 {
	public static void main(String[] args) {
		// MyJDBC mj = new MyJDBC();
		try {
			// 클래스 로드할때 사용
			// static - 여러가지로 활용가능
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
