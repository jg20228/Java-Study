package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//클래스 자료형 : Beans(콩들) : Model = Table(DB)
//Beans = 데이터만 들고 있는 것
@Data
@NoArgsConstructor  //Args = 매개변수
@AllArgsConstructor //No 빈생성자, All 모든 생성자
public class MenuItem {
	private String name;
	private int price;

	
}
