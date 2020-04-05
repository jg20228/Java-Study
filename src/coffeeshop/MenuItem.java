package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ŭ���� �ڷ��� : Beans(���) : Model = Table(DB)
//Beans = �����͸� ��� �ִ� ��
@Data
@NoArgsConstructor  //Args = �Ű�����
@AllArgsConstructor //No �������, All ��� ������
public class MenuItem {
	private String name;
	private int price;

	
}
