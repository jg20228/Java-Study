package composite;

public class ShrimpBurger extends Burger{
	
	public ShrimpBurger() {
		super(5500,"쉬림프 버거");
	}
	
	public ShrimpBurger(int price, String desc) {
		super(price, desc);
	}
}
