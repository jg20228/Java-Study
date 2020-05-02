package a02;

public class Explosion {
	// 여러개 폭팔 이미지 그리기위해 클래스로 객체 관리

	int x;// 이미지 그릴 x 좌표
	int y;// 이미지 그릴 y 좌표
	int ex_cnt;// 이미지를 순차적으로 그리기 위한 카운터
	int damage;// 이미지 종류를 구분하기 위한 변수값

	public Explosion(int x, int y, int damage) {
		this.x = x;
		this.y = y;
		this.damage = damage;
		ex_cnt = 0;
	}
	public void effect() {
		ex_cnt++;
	}
}
