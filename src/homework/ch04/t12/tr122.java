package homework.ch04.t12;

import java.util.Scanner;

class Concert {
	private String hallName;
	private Group[] group = new Group[3];
	private Scanner scanner = new Scanner(System.in);

	public Concert(String hallName) {
		this.hallName = hallName;
		group[0] = new Group('S', 10); // S Ÿ�� �¼� ����
		group[1] = new Group('A', 10); // A Ÿ�� �¼� ����
		group[2] = new Group('B', 10); // B Ÿ�� �¼� ����

	}

	private void reserve() { // �ܼ�Ʈ ����
		System.out.print("�¼����� S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
			return;
		}
		group[type - 1].reserve();

	}

	private void search() { // �ܼ�Ʈ ���� �˻�
		for (int i = 0; i < group.length; i++)
			group[i].show();
		System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
	}

	private void cancel() { // �ܼ�Ʈ ���� ���
		System.out.print("�¼� S:1, A:2, B:3>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
			return;
		}
		group[type - 1].cancel();
	}

	public void run() { // �ܼ�Ʈ ����/���/�˻� ��
		System.out.println(hallName + " ���� �ý����Դϴ�.");
		int choice = 0;
		while (choice != 4) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // ����
				reserve();
				break;
			case 2: // ��ȸ
				search();
				break;
			case 3: // ���
				cancel();
				break;
			case 4: // ������
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
}

class Group {
	private char type; // 'S', 'A', 'B' ���� ��Ÿ���� ����
	private Seat[] seats; // ���� ����� �¼� ��ü �迭
	private Scanner scanner = new Scanner(System.in);

	public Group(char type, int num) {
		this.type = type;
		seats = new Seat[num];
		for (int i = 0; i < seats.length; i++)
			seats[i] = new Seat();
	}

	public boolean reserve() { // ���� ����� �¼� ����
		int no;
		String name;
		show();
		System.out.print("�̸�>>");
		name = scanner.next();
		System.out.print("��ȣ>>");
		no = scanner.nextInt();
		if (no < 1 || no >= seats.length) {
			System.out.println("�߸��� �¼���ȣ�Դϴ�.");
			return false;
		}
		if (seats[no - 1].isOccupied()) { // �̹� ����� �¼� ��ȣ
			System.out.println("�̹� ����� �¼��Դϴ�.");
			return false;
		}
		seats[no - 1].reserve(name);
		return true;
	}

	public boolean cancel() { // ���� ����� �¼� ���
		show();
		System.out.print("�̸�>>"); // ����� ������ �̸� �Է�
		String name = scanner.next();
		if (name != null) {
			for (int i = 0; i < seats.length; i++) {
				if (seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("������ �̸��� ã�� �� �����ϴ�.");
		}
		return false; // ������ �̸��� ã�� ����
	}

	public void show() { // ���� ����� �¼� ���
		System.out.print(type + ">> ");
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isOccupied())
				System.out.print(seats[i].getName());
			else
				System.out.print("---");
			System.out.print(" ");
		}
		System.out.println();
	}
}

class Seat {
	private String name;

	public Seat() {
		name = null;
	}

	public String getName() {
		return name;
	}

	public void cancel() {
		name = null;
	}

	public void reserve(String name) {
		this.name = name;
	}

	public boolean isOccupied() {
		if (name == null) // �¼��� ����Ǿ� ������ true ��ȯ
			return false;
		else
			return true;
	}

	public boolean match(String name) {
		return (name.equals(this.name));
	}
}

public class tr122 {

	public static void main(String[] args) {
		Concert concert = new Concert("��ǰ�ܼ�ƮȦ");
		concert.run();
	}
}
