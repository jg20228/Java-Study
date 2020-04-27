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
			//�̷����ϸ� �޸𸮿��� �ߴµ� ��� �ּҸ� ã���� ��
			//OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����
			//Class.forName("oracle.jdbc.OracleDriver"); - �������� ���ؼ� ������� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ssar","bitc5600");//Stream
			//���� ����(?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 3);
			//���ۿ� ���� (ResultSet(�� *ù��° Ŀ��)�� ���� ����) 
			ResultSet rs = pstmt.executeQuery();
			
			Users users = null;
			
			//rs.next()�� Ŀ���� ���� ���������
			if(rs.next()) {
				users = new Users(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password"));
				System.out.println(users.getId()); //�÷����� ���°� �������� ����.
				System.out.println(users.getName());
				System.out.println(users.getEmail());
				System.out.println(users.getPassword());
				System.out.println("����Ʈ �Ϸ�");
			}//�Ѱ��̸� ������Ʈ, �������̸� �÷��ǿ� �־ �����ؾ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
