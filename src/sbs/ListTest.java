package sbs;

import java.util.ArrayList;
import java.util.List;

abstract class CardMaker {

}

class Card extends CardMaker {
	String name;

	public String getName(String name) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Card c = new Card();

		list.add("����Ʈ1");
		list.add("����Ʈ2");
		list.add(0, "����Ʈ3");

		System.out.println(list);
		
		c.setName(list.get(0));
		System.out.println(c.getName(list.get(0)));
	}

}
