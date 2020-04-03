package composite;

public class LotteriaApp {

	public static void main(String[] args) {
		//BigBurgerSet �߰���!!
		BigBurgerSet set1 = new BigBurgerSet();
		
		//Burger �߰���.
		Burger burger1 = new Burger();
		
		//�ݶ� �߰���.
		Coke coke1 =new Coke();
		
		//BigBurgerSet �߰� 1000�� ��������
//		BigBurgerSet set2 = 
//				new BigBurgerSet(
//						new BigBurger(3000,"���������"), 
//						new Coke(),
//						new FrenchFried()
//					);
		System.out.println(set1.getBigBurger().getPrice());

		//BigBurgerSet �߰� 2000�� ��������
		BigBurgerSet set3 = new BigBurgerSet(new BigBurger(2000,"���������"));
		System.out.println(set3.getBigBurger().getPrice());
		//������ż�Ʈ �߰���!!(2) or Set ������ �̿��ؼ� �߰�
		//BurgerSet set4 = new BurgerSet(new ShrimpBurger(2000,"������ ���� ����"));
		BurgerSet set4 = new BurgerSet(new ShrimpBurger(2000,"������ ��������"));
		System.out.println(set4.getCoke().getPrice());
	}

}
