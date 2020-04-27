package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx01 {
	
	public static void main(String[] args) {
		//Referenced Libraries
		try {
			final String SQL = "delete from users where id=?";
			//�̷����ϸ� �޸𸮿��� �ߴµ� ��� �ּҸ� ã���� ��
			//OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����
			//Class.forName("oracle.jdbc.OracleDriver"); - �������� ���ؼ� ������� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//���� ����(?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//set�� ������ ������
			pstmt.setInt(1, 1); //db�� 1���ͽ���
			//���ۿ� ���� (commit)
			pstmt.executeUpdate(); //-autoFlush
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
