package homework.ch04;

import java.util.Scanner;

class Day {
	private String work; // 하루의 할 일을 나타내는 문자열
	public void set(String work) { this.work = work; }
	public String get() { return work; }
	public void show() {
		if(work == null) System.out.println("없습니다.");
		else System.out.println(work + "입니다.");
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
		System.out.println("이번달 스케쥴 관리 프로그램.");
		while (true) {
			System.out.println("할일(입력:1, 보기:2, 끝내기:3) >>");
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
		System.out.println("날짜(1~30)");
		int days = sc.nextInt();
		System.out.println("할일(빈칸없이입력)?");
		String work = sc.next();
		day[days-1].set(work);
	}
	
	public void show() {
		System.out.println("날짜(1~30)");
		nDay = sc.nextInt();
		System.out.println(nDay+"일의 할일은 "+day[nDay-1].get()+"입니다.");
	}
	
	public void finish() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

	public static void main(String[] args) {
		tr07 tr07 = new tr07();
		tr07.run();
	}
}
