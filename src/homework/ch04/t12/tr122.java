package homework.ch04.t12;

import java.util.Scanner;

class Concert {
	private String hallName;
	private Group[] group = new Group[3];
	private Scanner scanner = new Scanner(System.in);

	public Concert(String hallName) {
		this.hallName = hallName;
		group[0] = new Group('S', 10); // S 타입 좌석 생성
		group[1] = new Group('A', 10); // A 타입 좌석 생성
		group[2] = new Group('B', 10); // B 타입 좌석 생성

	}

	private void reserve() { // 콘서트 예약
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("잘못된 좌석 타입입니다.");
			return;
		}
		group[type - 1].reserve();

	}

	private void search() { // 콘서트 예약 검색
		for (int i = 0; i < group.length; i++)
			group[i].show();
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}

	private void cancel() { // 콘서트 예약 취소
		System.out.print("좌석 S:1, A:2, B:3>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("잘못된 좌석 타입입니다.");
			return;
		}
		group[type - 1].cancel();
	}

	public void run() { // 콘서트 예약/취소/검색 등
		System.out.println(hallName + " 예약 시스템입니다.");
		int choice = 0;
		while (choice != 4) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // 예약
				reserve();
				break;
			case 2: // 조회
				search();
				break;
			case 3: // 취소
				cancel();
				break;
			case 4: // 끝내기
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}

class Group {
	private char type; // 'S', 'A', 'B' 석을 나타내는 문자
	private Seat[] seats; // 현재 등급의 좌석 객체 배열
	private Scanner scanner = new Scanner(System.in);

	public Group(char type, int num) {
		this.type = type;
		seats = new Seat[num];
		for (int i = 0; i < seats.length; i++)
			seats[i] = new Seat();
	}

	public boolean reserve() { // 현재 등급의 좌석 예약
		int no;
		String name;
		show();
		System.out.print("이름>>");
		name = scanner.next();
		System.out.print("번호>>");
		no = scanner.nextInt();
		if (no < 1 || no >= seats.length) {
			System.out.println("잘못된 좌석번호입니다.");
			return false;
		}
		if (seats[no - 1].isOccupied()) { // 이미 예약된 좌석 번호
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		seats[no - 1].reserve(name);
		return true;
	}

	public boolean cancel() { // 현재 등급의 좌석 취소
		show();
		System.out.print("이름>>"); // 취소할 예약자 이름 입력
		String name = scanner.next();
		if (name != null) {
			for (int i = 0; i < seats.length; i++) {
				if (seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("예약자 이름을 찾을 수 없습니다.");
		}
		return false; // 예약자 이름을 찾지 못함
	}

	public void show() { // 현재 등급의 좌석 출력
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
		if (name == null) // 좌석이 예약되어 있으면 true 반환
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
		Concert concert = new Concert("명품콘서트홀");
		concert.run();
	}
}
