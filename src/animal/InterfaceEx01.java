package animal;

//interface
//1.���� : public static final ����
//2.�Լ� : public abstract ����
//3.����� ���� - �������ε��ϴ� �뵵
//4.������ �߻�޼��常 ���簡�� = ���� Ŭ������ ������ �ο�
//5.new �� �� ����. (�ڽ��� new�ؼ� ���� heap���ߴ¹���ۿ� ����)

interface Cal{
	//public static final�� �����Ǿ��ִ�.
	int num = 10;
}

public class InterfaceEx01 {

	public static void main(String[] args) {
		System.out.println(Cal.num);
	}

}
