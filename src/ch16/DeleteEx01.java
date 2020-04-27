package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx01 {
	
	public static void main(String[] args) {
		//Referenced Libraries
		try {
			final String SQL = "delete from users where id=?";
			//이렇게하면 메모리에는 뜨는데 어떻게 주소를 찾는지 모름
			//OJDBC 문서에 해당 드라이버를 로드해라는 매뉴얼이 있음
			//Class.forName("oracle.jdbc.OracleDriver"); - 옛버전을 위해서 사라지진 않음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//스트림 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//버퍼 장착(?를 사용하게 해준다)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//set에 오만거 다있음
			pstmt.setInt(1, 1); //db는 1부터시작
			//버퍼에 쓰기 (commit)
			pstmt.executeUpdate(); //-autoFlush
			System.out.println("삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
