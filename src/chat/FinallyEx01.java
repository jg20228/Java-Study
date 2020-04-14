package chat;

interface StarUnit {
	abstract int getHp();
}

abstract class Protoss implements StarUnit {
	abstract int getSh();
}

abstract class Zerg implements StarUnit {
}

class Zealot extends Protoss {
	int hp = 100;
	int sh = 100;

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public int getSh() {
		return sh;
	}
}

class Ultra extends Zerg {
	int hp = 400;
	@Override
	public int getHp() {
		return hp;
	}
}

public class FinallyEx01 {

	// ����üũ, (hp, sh)
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot) unit; //�ٿ�ĳ����
			System.out.println("���� ����� : " + z.getSh());
		} catch (Exception e) {//���α׷����� �ƴ϶� ������ �����ϴ°�
			//����
			Ultra u = (Ultra) unit;
			System.out.println("���״� ���尡 �����ϴ�");
			System.out.println("���� ü���� : " + u.getHp());
		}finally {
			//try->catch->finally�� ������ �����
			//������ ���� �ȳ��� �������ؾ��ϴ� ���� finally���� ó��
			//��ſ����� Socket, BufferedReader, BufferedWriter�� �ݾƾ���
			System.out.println("���� ������ ����");
		}
	}

	public static void main(String[] args) {
		check(new Zealot());
		System.out.println();
		check(new Ultra());
	}
}
