package ch04;

//����(state)�� �ൿ(behavior)
public class Person {
	String name;
	String job;
	int age;
	char gender;
	String bloodType;

	// ����Ʈ ������-�Ű������� ���� ����
	// (�뵵:�ʱ�ȭ)Ŭ������ �Ȱ��� �̸��� ���� �Լ�
	public Person() {
	}

	// �Ű������� �ִ� ������
	// �����ε�
	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
}
