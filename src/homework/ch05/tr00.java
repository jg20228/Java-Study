package homework.ch05;

import java.util.Scanner;

public class tr00 {
	public static final int BUS = 1200;
	public static final int SUBWAY = 1250;
	public static final int TAXI = 3800;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� �Է�");
		String trans = scanner.next();
		//�Է°��� ����, ����ö, �ý����� �˻�
		if (trans.equals("����") || trans.equals("����ö") || trans.equals("�ý�")) {
			System.out.println("�̵��Ÿ�(km) �Է�");
			int way = scanner.nextInt(); //�̵��Ÿ� �Է�
			int pay = 0; //��� ���� �� �ʱ�ȭ
			int transit = 0; //�̵� ��� ��� ����
			//--------������ ����ö ��� ����
			if (trans.equals("����")) {
				pay = BUS;
			} else if (trans.equals("����ö")) {
				pay = SUBWAY;
			}
			//10km �ʰ��� �߰� ���
			if (way > 10) {
				transit = (((way - 10) / 5) + 1) * 100;
			}
			//�ýô� �⺻���, �ƴҰ�� ����,����ö�̹Ƿ� ���� ���
			if (trans.equals("�ý�")) {
				System.out.println("�ýô� �⺻��� " + TAXI + "�� ������ �̵��մϴ�.");
			} else {
				System.out.println("�Է� ���������" + trans + "�̰�, �̵��Ÿ��� " + way + "km�Դϴ�. " + "�⺻����� " 
						+ pay + "�� �̰�, ���������"+ (pay + transit) + "�� �Դϴ�.");
			}
			//�Է��� ���������� ����,����ö,�ýð� �ƴϸ� ����
		} else {
			System.out.println(trans + "�� ���߱����� �ƴմϴ�.");
		}//ù if��
	}//main
}//class
