package ch03;

//�޼���(�Լ�)�� Ŭ�����ȿ� �ۼ��� �� �ִ�.
//�޼���(�Լ�)�� �޼���ȿ� �ۼ��� �� ����.
public class MethodEx01 {

	public static void main(String[] args) {
		int num = Cal.add(5, 3);
		System.out.println("��� : " + num);

		num = Cal.minus(5, 3);
		System.out.println("��� : " + num);
		
		num = Cal.multi(5, 3);
		System.out.println("��� : " + num);
		
		num = Cal.divide(5, 3);
		System.out.println("��� : " + num);
	}

}
