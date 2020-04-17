package ch06;

class Person {
	String name = "ȫ�浿";
	int age = 15;
	String job = "�л�";

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	// ��Ŭ�� Source -> Generate toString()�ϸ� ���� �ڵ� ����
	// �������̵��ؼ� �ڱ⸸�� �����ǰ� �Ǿ�����.
}

public class ObjectEx02 {
	// toString()
	// ��� ������Ʈ�� toString �Ҽ� �ִ�.
	public static void main(String[] args) {
		Integer num = 10;
		String s = Integer.toString(num);
		System.out.println(s);

		Person p = new Person();
		// ������ �̰ǵ� return type�� String�̴�. <���� �߿��� '���� Stringȭ' �Ҽ� �ִ�.
		// getClass().getName() + "@" + Integer.toHexString(hashCode());
		System.out.println(p.toString());
		// �ּҸ� ȣ���ϸ� �ڵ����� toString�� ����.
		System.out.println(p);

		StringBuilder sb = new StringBuilder();
		sb.append("�ȳ�");
		sb.append("�ݰ���");

		System.out.println(sb.toString());
		// Stringȭ �ؼ� return ������
//	    public String toString() {
//	        // Create a copy, don't share the array
//	        return new String(value, 0, count);
//	    }

	}
}
