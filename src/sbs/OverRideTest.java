package sbs;

abstract class LifeContents {
	abstract public void setLv(int lv);

	abstract public int getLv();

	abstract public void setPoint(int point);

	abstract public int getPoint();

}

class Mining extends LifeContents {
	private int lv;
	private int point;

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}

class Gathering extends LifeContents {
	private int lv;
	private int point;

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}

class Felling extends LifeContents {
	private int lv;
	private int point;

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}

public class OverRideTest {

	public static void main(String[] args) {
		Felling f = new Felling();
		f.setLv(f.getLv()+1);
		f.setPoint(f.getPoint()+1);
		
		System.out.println(f.getLv());
		System.out.println(f.getPoint());

	}

}
