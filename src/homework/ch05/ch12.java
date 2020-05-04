package homework.ch05;

import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() {next=null;}
	public void setNext(Shape obj) {next=obj;}
	public Shape getNext() {return next;}
	public abstract void draw();
}

class Line extends Shape{
	@Override
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape{
	@Override
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}

class GraphicEditor{
	private String name;
	Scanner sc = new Scanner(System.in);
	public GraphicEditor(String name) {
		this.name = name;
	}	
	
	public void run() {
		System.out.println(name+" ½ÇÇà");
		
	}
}


public class ch12 {
	public static void main(String[] args) {
		GraphicEditor ge = new GraphicEditor("beauty");
		ge.run();
	}
}
