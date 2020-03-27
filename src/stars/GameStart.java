package stars;

//다크템플러 Dark Templer, 리버 River

//오버로딩
class Zealot {
	final String NAME;
	int hp;
	static int attack = 10;

	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
	}

}

class Dragoon {
	final String NAME;
	int hp;
	static int attack = 15;

	public Dragoon(String name) {
		this.NAME = name;
		this.hp = 100;
	}

}

class DarkTempler {
	final String NAME;
	int hp;
	static int attack = 50;

	public DarkTempler(String name) {
		this.NAME = name;
		this.hp = 100;
	}

}

class River {
	final String NAME;
	int hp;
	static int attack = 70;

	public River(String name) {
		this.NAME = name;
		this.hp = 100;
	}

}

public class GameStart {

	// 질럿=>질럿
	static void attack(Zealot u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 질럿=>드라군
	static void attack(Zealot u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 질럿=>다크템플러
	static void attack(Zealot u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 질럿=>리버
	static void attack(Zealot u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 드라군=>질럿
	static void attack(Dragoon u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 드라군=>드라군
	static void attack(Dragoon u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 드라군=>다크템플러
	static void attack(Dragoon u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 드라군=>리버
	static void attack(Dragoon u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 다크템플러=>질럿
	static void attack(DarkTempler u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 다크템플러=>드라군
	static void attack(DarkTempler u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 다크템플러=>다크템플러
	static void attack(DarkTempler u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 다크템플러=>리버
	static void attack(DarkTempler u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 리버=>질럿
	static void attack(River u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 리버=>드라군
	static void attack(River u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 리버=>다크템플러
	static void attack(River u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	// 리버=>리버
	static void attack(River u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은 " + u2.hp + "입니다.");
	}

	public static void main(String[] args) {
		// 공격력 업그레이드하기
		Zealot.attack++;
		// 질럿 생성하기
		Zealot z1 = new Zealot("1번질럿");
		System.out.println(Zealot.attack);
		Zealot z2 = new Zealot("2번질럿");
		System.out.println(Zealot.attack);
		Dragoon d1 = new Dragoon("1번드라군");
		Dragoon d2 = new Dragoon("2번드라군");
		DarkTempler dk1 = new DarkTempler("1번다크템플러");
		DarkTempler dk2 = new DarkTempler("2번다크템플러");
		River r1 = new River("1번리버");
		River r2 = new River("2번리버");
		System.out.println(Dragoon.attack);

		// 질럿 공격하기
		attack(z1, z2);
		attack(z1, d1);
		attack(z1, dk1);
		attack(z1, r1);
		// 드라군 공격하기
		attack(d1, z1);
		attack(d1, d2);
		attack(d1, dk1);
		attack(d1, r1);
		// 다크템플러 공격하기	
		attack(dk1, z1);
		attack(dk1, d2);
		attack(dk1, dk2);
		attack(dk1, r1);
		// 리버 공격하기
		attack(r1, z1);
		attack(r1, d2);
		attack(r1, dk1);
		attack(r1, r2);
	}

}
