package ch03;

//�޼���(�Լ�)�� Ŭ�����ȿ� �ۼ��� �� �ִ�.
//�޼���(�Լ�)�� �޼���ȿ� �ۼ��� �� ����.
public class MethodEx01 {

	static int add(int n1, int n2) {
		int result = n1 + n2;
		// System.out.println("result : " + result);
		return result; // return ���� ��������!!
	}
	//minus(�Ű������� int�� �ΰ�) (return�� int��)
	static int minus(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}
	static int multi(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	static int divide(int n1, int n2) {
		int result = n1 / n2;
		return result;
	}

	public static void main(String[] args) {
		int num = MethodEx01.add(5, 3);
		System.out.println("��� : " + num);

		num = MethodEx01.minus(5, 3);
		System.out.println("��� : " + num);
		
		num = MethodEx01.multi(5, 3);
		System.out.println("��� : " + num);
		
		num = MethodEx01.divide(5, 3);
		System.out.println("��� : " + num);
	}

}
