package coffeeshop;

import java.util.ArrayList;
import lombok.Data;

//å�� : �޴�����
@Data
public class Menu {
	// �޴� �����۵�(�÷���)
	private ArrayList<MenuItem> menuItems;
<<<<<<< HEAD
	//�ؿ� public->private->11Line
=======
>>>>>>> 95a3dff5adebc916a8ad87916aafa6dc49fc6f93
	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}


	public MenuItem �޴�����(String menuName) {
		//for each
		//������ �迭�� ũ�� ��ŭ for�� ���ư�
		//Ÿ�� ������(���) : 
		for (MenuItem menuItem : menuItems) {
			if(menuItem.getName().equals(menuName)) {
				return menuItem;
			}
		}
		return null;
	}
}
