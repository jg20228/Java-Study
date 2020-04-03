package coffeeshop;

import java.util.ArrayList;

import lombok.Data;

//책임 : 메뉴선택
@Data
public class Menu {

	// 메뉴 아이템들(컬렉션)
	private ArrayList<MenuItem> menuItems;

	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public MenuItem 메뉴선택(String menuName) {
		// for each
		// 오른쪽 배열의 크기 만큼 for문 돌아감
		// 타입 변수명(요소) :
		for (MenuItem menuItem : menuItems) {
			if (menuItem.getName().equals(menuName)) {
				return menuItem;
			}
		}
		return null;
	}
}
