package composite;

import lombok.Data;

//composition
//�߸���� ������ �����Ҷ� composition
//�ڹٴ� ���� ����� �ȵ�
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
