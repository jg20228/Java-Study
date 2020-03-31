package stars;

//추상클래스와 유사
//추상메서드만 존재가능
public interface Behavior {
	//public abstract 생략됨
	void move();
	void repair();
	void attack(Behavior unit);
	
	////////
	int getHp();
	void setHp(int i);
	
	String getName();

}
