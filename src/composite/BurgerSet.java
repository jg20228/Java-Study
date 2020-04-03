package composite;

import lombok.Data;

@Data
public class BurgerSet {
	private Burger burger;
	private Coke coke;
	private FrenchFried frenchFried;

	public BurgerSet() {
		this(new Burger(), new Coke(), new FrenchFried());
	}

	public BurgerSet(Burger burger) {
		this.burger = burger;
		this.coke = new Coke();
		this.frenchFried = new FrenchFried();

	}

	public BurgerSet(Burger burger, Coke coke, FrenchFried frenchFried) {
		this.burger = burger;
		this.coke = coke;
		this.frenchFried = frenchFried;

	}

}
