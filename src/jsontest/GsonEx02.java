package jsontest;

import com.google.gson.Gson;

public class GsonEx02 {

	public static void main(String[] args) {
		//Ŭ���� ���� ����� ����Ʈ
		//http://www.jsonschema2pojo.org/
		String jsonPerson = "{\"�̸�\":\"ȫ�浿\",\"����\":25,\"����\":\"��\",\"�ּ�\":\"����Ư���� ��õ�� ��\",\"Ư��\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}\r\n" + 
				"";
		Gson gson = new Gson();
	}

}
