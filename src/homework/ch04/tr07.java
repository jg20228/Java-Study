package homework.ch04;

import java.util.Scanner;

class Day {
	private String work; // �Ϸ��� �� ���� ��Ÿ���� ���ڿ�
	public void set(String work) { this.work = work; }
	public String get() { return work; }
	public void show() {
		if(work == null) System.out.println("�����ϴ�.");
		else System.out.println(work + "�Դϴ�.");
	}
}

public class tr07 {
	Day day[];
	Scanner sc = new Scanner(System.in);
	int input;
	String type;
	int nDay;

	public void run() {
		day = new Day[30];
		for (int i = 0; i < day.length; i++) {
			day[i] = new Day();
		}
		System.out.println("�̹��� ������ ���� ���α׷�.");
		while (true) {
			System.out.println("����(�Է�:1, ����:2, ������:3) >>");
			input = sc.nextInt();
			if (input == 1) {
				type();
			} else if (input == 2) {
				show();
			} else if (input == 3) {
				finish();
				break;
			}
		}
	}

	public void type() {
		System.out.println("��¥(1~30)");
		int days = sc.nextInt();
		System.out.println("����(��ĭ�����Է�)?");
		String work = sc.next();
		day[days-1].set(work);
	}
	
	public void show() {
		System.out.println("��¥(1~30)");
		nDay = sc.nextInt();
		System.out.println(nDay+"���� ������ "+day[nDay-1].get()+"�Դϴ�.");
	}
	
	public void finish() {
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
	}

	public static void main(String[] args) {
		tr07 tr07 = new tr07();
		tr07.run();
	}
}
