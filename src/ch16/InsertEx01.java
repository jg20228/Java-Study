package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEx01 {
	
	public static void main(String[] args) {
		//Referenced Libraries
		try {
			final String SQL = "insert into users(id,name,email,password) values(?,?,?,?)";
			//�̷����ϸ� �޸𸮿��� �ߴµ� ��� �ּҸ� ã���� ��
			//OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����
			//Class.forName("oracle.jdbc.OracleDriver"); - �������� ���ؼ� ������� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//���� ����(?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//set�� ������ ������
//			pstmt.setInt(1, 1); //db�� 1���ͽ���
//			pstmt.setString(2, "ȫ�浿");
//			pstmt.setString(3, "ssar@nate.com");
//			pstmt.setString(4, "1234");
//			pstmt.setInt(1, 3); //db�� 1���ͽ���
//			pstmt.setString(2, "�̸�");
//			pstmt.setString(3, "ssar@nate.com");
//			pstmt.setString(4, "1234");
//			pstmt.setInt(1, 4); //db�� 1���ͽ���
//			pstmt.setString(2, "������");
//			pstmt.setString(3, "ssar@nate.com");
//			pstmt.setString(4, "1234");
			//���ۿ� ���� (commit)
			pstmt.executeUpdate(); //-autoFlush
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
