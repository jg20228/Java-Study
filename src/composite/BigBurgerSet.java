package composite;

import lombok.Data;

//composition
//잘만들어 놓은걸 재사용할때 composition
//자바는 다중 상속이 안됨
//BigBurger <-> Burger

@Data
public class BigBurgerSet {
	private BigBurger bigBurger;
	private Coke coke;
	private FrenchFried frenchFried;

	public BigBurgerSet() {
		this(new BigBurger());
		this.coke = new Coke(); 
		this.frenchFried = new FrenchFried();

	}

	public BigBurgerSet(BigBurger bigBurger) {
		this.bigBurger = bigBurger;

	}

}
