package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx01 {
	
	public static void main(String[] args) {
		//Referenced Libraries
		try {
			final String SQL = "select id,name,email,password from users where id =?";
			//이렇게하면 메모리에는 뜨는데 어떻게 주소를 찾는지 모름
			//OJDBC 문서에 해당 드라이버를 로드해라는 매뉴얼이 있음
			//Class.forName("oracle.jdbc.OracleDriver"); - 옛버전을 위해서 사라지진 않음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//스트림 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//버퍼 장착(?를 사용하게 해준다)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 3);
			//버퍼에 쓰기 (ResultSet(의 *첫번째 커서)을 리턴 받음) 
			ResultSet rs = pstmt.executeQuery();
			
			Users users = null;
			
			//rs.next()로 커서를 한줄 내려줘야함
			if(rs.next()) {
				users = new Users(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password"));
				System.out.println(users.getId()); //컬럼명을 적는게 가독성에 좋다.
				System.out.println(users.getName());
				System.out.println(users.getEmail());
				System.out.println(users.getPassword());
				System.out.println("셀렉트 완료");
			}//한건이면 오브젝트, 여러건이면 컬렉션에 넣어서 관리해야함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
