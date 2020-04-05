package composite2;

public class Triangle implements Shape {
	private String color;
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color "+fillColor);
        this.color=fillColor;
    }
}
