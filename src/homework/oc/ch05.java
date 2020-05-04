package homework.oc;

import java.util.Scanner;

abstract class GameObject {
	protected int distance;
	protected int x, y;

	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean collide(GameObject p) {
		if (this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}

	protected abstract void move(); // 이동후 새로운 위치로 x, y 변경

	protected abstract char getShaper(); // 객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject {
	private Scanner sc = new Scanner(System.in);
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	@Override
	protected void move() {
		char input;
		System.out.println("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
		input = sc.next().charAt(0);
		switch (input) {
		case 'a':
			if(this.y<=0) {
				this.y = 0;
			}else {
				this.y--;
			}
			break;
		case 's':
			if(this.x>=10) {
				this.x = 10;
			}else {
				this.x++;
			}
			break;
		case 'd':
			if(this.x<=0) {
				this.x = 0;
			}else {
				this.x--;
			}
			break;
		case 'f':
			if(this.y>=19) {
				this.y = 19;
			}else {
				this.y++;
			}
			break;
		}
	}
	@Override
	protected char getShaper() {
		return 'B';
	}
}

class Fish extends GameObject {
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	@Override
	protected void move() {
		int ran = (int) (Math.random() * 3 + 1);
		switch (ran) {
		case 0:
			if(this.x<=0) {
				this.x=0;
			}else {
				this.x--;	
			}
			break;
		case 1:
			if(this.x>=10) {
				this.x=10;
			}else {
				this.x++;
			}
			break;
		case 2:
			if(this.y<=0) {
				this.y=0;
			}else {
				this.y--;
			}
			break;
		case 3:
			if(this.y>=19) {
				this.y=19;
			}else {
				this.y++;
			}
			break;
		}
	}
	@Override
	protected char getShaper() {
		return '@';
	}
}

public class ch05 {
	char[][] xy;
	Bear bear;
	Fish fish;
	String input="";
	int moveCount;

	public ch05() {
		xy = new char[10][20];
		bear = new Bear(0, 0, 1);
		fish = new Fish((int) (Math.random() * 9 + 1), (int) (Math.random() * 19 + 1), 1);

		moveCount = 1;
		System.out.println("**Bear의 Fish 먹기 게임을 시작합니다.**");
		while (true) {
			System.out.println(fish.getX()+" "+fish.getY());
			viewMap();
			bear.move();
			if (bear.getX() == fish.getX() && bear.getY() == fish.getY()) {
				viewMap();
				System.out.println("Bear Wins!!");
				break;
			}
			if(moveCount % 4 == 0 || moveCount % 5 ==0 ) {
				fish.move();
			}
			moveCount++;
		}
	}

	public void viewMap() {
		for (int i = 0; i < xy.length; i++) {
			for (int j = 0; j < xy[i].length; j++) {
				if (bear.getX() == i && bear.getY() == j) {
					xy[i][j] = bear.getShaper();
				} else if (fish.getX() == i && fish.getY() == j) {
					if(bear.getX()==fish.getX()&&bear.getY()==fish.getY()) {
					}else {
						xy[i][j] = fish.getShaper();
					}
				} else {
					xy[i][j] = '-';
				}
				System.out.print(xy[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new ch05();
	}
}
