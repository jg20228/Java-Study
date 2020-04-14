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

	// 상태체크, (hp, sh)
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot) unit; //다운캐스팅
			System.out.println("남은 쉴드는 : " + z.getSh());
		} catch (Exception e) {//프로그래밍이 아니라 오류를 검증하는곳
			//저그
			Ultra u = (Ultra) unit;
			System.out.println("저그는 쉴드가 없습니다");
			System.out.println("남은 체력은 : " + u.getHp());
		}finally {
			//try->catch->finally는 무조건 실행됨
			//오류가 나든 안나든 무조건해야하는 것은 finally에서 처리
			//통신에서는 Socket, BufferedReader, BufferedWriter을 닫아야함
			System.out.println("나는 무조건 실행");
		}
	}

	public static void main(String[] args) {
		check(new Zealot());
		System.out.println();
		check(new Ultra());
	}
}
