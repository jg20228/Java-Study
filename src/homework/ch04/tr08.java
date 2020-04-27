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
		System.out.println("인원수");
		Phone player[] = new Phone[sc.nextInt()];
		for (int i = 0; i < player.length; i++) {
			player[i] = new Phone();
			System.out.println("이름");
			player[i].setName(sc.next());
			System.out.println("전화번호");
			player[i].setTel(sc.next());
		}

		while (true) {
			System.out.println("검색할 이름");
			String input;
			input = sc.next();

			for (int j = 0; j < player.length; j++) {
				System.out.println(player[j].getName());
				if (player[j].getName().equals(input)) {
					System.out.println(player[j].getName() + "의 번호는 " + player[j].getTel() + " 입니다.");
				}
			}
			if (input.equals("그만"))
				break;
		}
		sc.close();
	}
}
