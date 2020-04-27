package homework.ch04;

import java.util.Scanner;


class Concert {
	private String concertName;
	private Scanner sc = new Scanner(System.in);
	private Group[] group = new Group[3];
	
	public Concert(String name) {
		this.concertName = name;
		group[0] = new Group("S",10);
		group[1] = new Group("A",10);
		group[2] = new Group("B",10);
	}

	public void run() {
		System.out.println(concertName + " 예약 시스템입니다.");
		while (true) {
			System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			int a = sc.nextInt();
			if (a == 1) {
				reserve();
			} else if (a == 2) {
				show();
			} else if (a == 3) {
				cancle();
			} else if (a == 4) {
				break;
			}
		}
	}
	
	public void reserve() {
		System.out.println("좌석 S:1, A:2, B:3>>");
		int input=sc.nextInt();
		for (int i = 0; i < group[input-1].getNum(); i++) {
			System.out.print(group[input-1].getSize(i)+" ");
		}System.out.println();
		System.out.println("이름>>");
		String name = sc.next();
		System.out.println("번호>>");
		int num = sc.nextInt();
		
		//group[input-1].getSize(num-1).reserve(name);
		group[input-1].reserve(name, num-1);
	}
	
	public void show() {
		for (int i = 0; i < group.length; i++) {
			System.out.print(group[i].getName()+">> ");
			for (int j = 0; j < group[i].getNum(); j++) {
				System.out.print(group[i].getSize(j)+" ");
			}System.out.println();
		}
	}
	
	public void cancle() {
		System.out.println("좌석 S:1, A:2, B:3>>");
		int input=sc.nextInt();
		for (int i = 0; i < group[input].getNum(); i++) {
			System.out.println(group[input].getName()+" ");
		}
		System.out.println("이름>>");
		String name = sc.next();
		for (int i = 0; i < group[input].getNum(); i++) {
			if(group[i].getSize(i).getName().equals(name)) {
				group[i].getSize(i).cancel();
			}
		}
	}
}

class Group{
	private String name;
	private Seat size[];
	private int num;
	public Group(String s,int a) {
		this.name = s;
		size = new Seat[a];
		for (int i = 0; i < size.length; i++) {
			size[i] = null;
		}
		num = a;
	}
	public String getName() {
		return name;
	}
	
	public Seat getSize(int a) {
		return size[a];
	}
	public int getNum() {
		return num;
	}
	
	public void reserve(String s,int i) {
		size[i].reserve(s);
	}
}


class Seat{
	private String name;
	public Seat() {
		name = null;
	}
	
	public String getName() {
		if(this.name==null) {
			String a="--- ";
			return a; 
		}
		return name;
	}
	public void cancel() {
		name = null;
	}
	public void reserve(String name) {
		this.name=name;
	}
}

public class tr12 {

	public static void main(String[] args) {
		Concert concert = new Concert("명품콘서트홀");
		concert.run();
	}

}
