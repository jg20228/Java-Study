package a02;

public class Explosion {
	// ������ ���� �̹��� �׸������� Ŭ������ ��ü ����

	int x;// �̹��� �׸� x ��ǥ
	int y;// �̹��� �׸� y ��ǥ
	int ex_cnt;// �̹����� ���������� �׸��� ���� ī����
	int damage;// �̹��� ������ �����ϱ� ���� ������

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
