package composite2;

public class Circle implements Shape {
	private String color;
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
        this.color=fillColor;
    }
}
