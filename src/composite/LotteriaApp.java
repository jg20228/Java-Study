package composite;

public class LotteriaApp {

	public static void main(String[] args) {
		//BigBurgerSet 추가요!!
		BigBurgerSet set1 = new BigBurgerSet();
		
		//Burger 추가요.
		Burger burger1 = new Burger();
		
		//콜라 추가요.
		Coke coke1 =new Coke();
		
		//BigBurgerSet 추가 1000원 할인쿠폰
//		BigBurgerSet set2 = 
//				new BigBurgerSet(
//						new BigBurger(3000,"빅버거할인"), 
//						new Coke(),
//						new FrenchFried()
//					);
		System.out.println(set1.getBigBurger().getPrice());

		//BigBurgerSet 추가 2000원 할인쿠폰
		BigBurgerSet set3 = new BigBurgerSet(new BigBurger(2000,"빅버거할인"));
		System.out.println(set3.getBigBurger().getPrice());
		//새우버거세트 추가요!!(2) or Set 다형성 이용해서 추가
		//BurgerSet set4 = new BurgerSet(new ShrimpBurger(2000,"쉬림프 버거 할인"));
		BurgerSet set4 = new BurgerSet(new ShrimpBurger(2000,"쉬림프 버거할인"));
		System.out.println(set4.getCoke().getPrice());
	}

}
