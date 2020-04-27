package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx1 {
	
	public static void main(String[] args) {
		//Referenced Libraries
		try {
			final String SQL = "update users set password = ? where id = ?";
			//�̷����ϸ� �޸𸮿��� �ߴµ� ��� �ּҸ� ã���� ��
			//OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����
			//Class.forName("oracle.jdbc.OracleDriver"); - �������� ���ؼ� ������� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//���� ����(?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//set�� ������ ������
			pstmt.setString(1, "5678"); //db�� 1���ͽ���
			pstmt.setInt(2, 2);
			//���ۿ� ���� (commit)
			pstmt.executeUpdate(); //-autoFlush
			System.out.println("������Ʈ �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
