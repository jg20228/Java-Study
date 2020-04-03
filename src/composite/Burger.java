package composite;

import lombok.Data;

@Data // Getter, Setter 자동 생성
public class Burger {
	private int price; // 가격
	private String desc; // 설명

	public Burger() {
		this(1500,"기본버거");
	}
	//최종 목적지
	public Burger(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc+"가 만들어졌습니다.");
	}

}
