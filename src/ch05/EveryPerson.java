package ch05;

class ��� {
	int num = 10;
}
class �ƽþ��� extends ��� {
	int num = 30;
}
class �ѱ��� extends �ƽþ��� {

}
//class ��� {�ٸ� Ʈ��}
class �ڼ��� extends �ѱ��� {
	int num = 20;
}
public class EveryPerson {

	public static void main(String[] args) {
		// ��ĵ�� �ڼ���->�ѱ���->�ƽþ���->���
		�ڼ��� b1 = new �ڼ���();
		System.out.println(b1.num);

		// ��ĵ�� �ѱ���->�ƽþ���->���
		�ѱ��� b2 = new �ڼ���(); //��ĳ����(������ ����ȯ)
		System.out.println(b2.num);
		
		//�ٿ�ĳ����
		�ڼ��� downB2= (�ڼ���)b2;
		System.out.println("downB2 : "+downB2.num);
		
		// ��ĵ�� ���
		��� b3 = new �ѱ���();
		System.out.println(b3.num);
		//�ڼ��� downB3 = (�ڼ���) b3;
		//�޸𸮿� �ڼ����� ��� ������ ��
		
		// new���ϸ� extends�� ��ŭ �޸𸮿� ���
		// ����Ű�� ����� �տ� ���´�
	}
}
