package jsontest;

import com.google.gson.Gson;

class Person{
	//Ű ���� �Ȱ��ƾ��Ѵ�.
	String �̸�;
	int ����;
	String ����;
	String �ּ�;
	String[] Ư��;//Json�� �˾Ƽ� new�� ���ش�.(���൵ �������)
	Family ��������;
	String ȸ��;
}

class Family{
	int ��;
	String �ƹ���;
	String ��Ӵ�;
	
}

public class GsonEx01 {
	public static void main(String[] args) {
		//JsonEx01�� JsonParser���� ���Ѱ�
		//http://json.parser.online.fr/
		String jsonPerson="{\"�̸�\":\"ȫ�浿\",\"����\":25,\"����\":\"��\",\"�ּ�\":\"����Ư���� ��õ�� ��\",\"Ư��\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}\r\n" + 
				"";
		// �������� \�� �״��� ���ڸ� ������
		Gson gson = new Gson();
		Person p = gson.fromJson(jsonPerson,Person.class);
		System.out.println(p.Ư��[0]);
	}
}
