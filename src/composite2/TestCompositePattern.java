package composite2;

import java.util.ArrayList;
import java.util.List;

public class TestCompositePattern {

	public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();
		
        Drawing drawing = new Drawing();
        drawing.add(tri);
        drawing.add(tri1);
        drawing.add(cir);
		
        drawing.draw("Red");

        System.out.println(drawing.getShapes());
        List<Shape> shapes = new ArrayList<>();
        shapes.add(drawing);
        shapes.add(new Triangle());
        shapes.add(new Circle());
        
        System.out.println(drawing);
        System.out.println("----------------");
        
        
        for(Shape shape : shapes) {
            shape.draw("Green");
            
        }
        System.out.println(shapes);
        shapes.clear();

	}

}
