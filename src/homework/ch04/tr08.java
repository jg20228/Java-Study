package homework.ch04;

import java.util.Scanner;

class Phone {
	private String name;
	private String tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}

public class tr08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ο���");
		Phone player[] = new Phone[sc.nextInt()];
		for (int i = 0; i < player.length; i++) {
			player[i] = new Phone();
			System.out.println("�̸�");
			player[i].setName(sc.next());
			System.out.println("��ȭ��ȣ");
			player[i].setTel(sc.next());
		}

		while (true) {
			System.out.println("�˻��� �̸�");
			String input;
			input = sc.next();

			for (int j = 0; j < player.length; j++) {
				System.out.println(player[j].getName());
				if (player[j].getName().equals(input)) {
					System.out.println(player[j].getName() + "�� ��ȣ�� " + player[j].getTel() + " �Դϴ�.");
				}
			}
			if (input.equals("�׸�"))
				break;
		}
		sc.close();
	}
}
