package homework.ch05;

class Point {
	private int x, y;
	public Point() {}
	public Point(int x, int y) {this.x = x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
	public void setXY(int x,int y) {this.x=x; this.y=y;}	
}

class ColorPoint extends Point{
	private String color;
	
	public ColorPoint() {
		super(0,0);
	}
	
	
	public ColorPoint(int x, int y) {
		super(x, y);
	}
	public ColorPoint(int x, int y,String color) {
		super(x, y);
		this.color = color;
	}
	public void setColor(String color) {
		this.color = color;
	}	
	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		String a="";
		System.out.println(getColor()+"색의 "+"("+getX()+","+getY()+")의 점");
		return a;
	}
}

class Point3D extends Point{
	private int x;
	private int y;
	private int z;
	
	public Point3D(int x, int y) {
		super(x, y);
	}
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}

	public void moveUp() { this.z++;}
	public void moveDown() {this.z--;}
	
	public void move(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public int getZ() {return z;}
	public void setZ(int z) {this.z = z;}

	@Override
	public String toString() {
		String a="("+getX()+","+getY()+","+getZ()+")"+"의 점";
		return a;
	}
}

class PositivePoint extends Point{
	private int x;
	private int y;
		
	public PositivePoint() {
		this.x=0;
		this.y=0;
	}
	
	public PositivePoint(int x, int y) {
		super(x, y);
	}
	
	@Override
	protected void move(int x, int y) {
		if(x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
		}else if(x<0 && y<0) {
			this.x = 0;
			this.y = 0;
		}
	}
	
	
	
	@Override
	public String toString() {
		String a="("+this.x+","+this.y+")"+"의 점";
		return a;
	}
	
}




public class tr05to08 {

	public static void main(String[] args) {
		//5번
//		ColorPoint cp = new ColorPoint(5,5,"YELLOW");
//		cp.setXY(10, 20);
//		cp.setColor("RED");
//		cp.tString();
		//6번
//		ColorPoint zeroPoint = new ColorPoint();
//		
//		ColorPoint cp2 = new ColorPoint(10,10);
//		cp2.setXY(5, 5);
//		cp2.setColor("RED");
//		cp2.tString();
		//7번
//		Point3D p = new Point3D(1,2,3);
//		System.out.println(p.toString()+"입니다");
//		
//		p.moveUp();
//		System.out.println(p.toString()+"입니다");
//		
//		p.moveDown();
//		p.move(10, 10);
//		System.out.println(p.toString()+"입니다");
//		
//		p.move(10, 200,300);
//		System.out.println(p.toString()+"입니다");
		
		//8번
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() +"입니다");
		
		p.move(-5, 5);
		System.out.println(p.toString() +"입니다");

		p.move(-5, -5);
		System.out.println(p.toString() +"입니다");
	}
}
