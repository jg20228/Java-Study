package ch16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//��, Beans(��)
//DB�� ���ڵ带 �ڹټ����� ������Ʈ�� �ٲٴ°� = �𵨸�
@Data
@NoArgsConstructor //�� ������
@AllArgsConstructor //���� ä�� ������
public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
}
