package homework.ch05;

class TV {
	private int size;

	public TV(int size) {
		this.size = size;
	}

	protected int getSize() {
		return size;
	}
}

class ColorTV extends TV {
	private int color;

	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}

	public int getColor() {
		return color;
	}
}

class IPTV extends ColorTV {
	private String ip;

	public IPTV(String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}

	public void printProperty() {
		System.out.println("나의 IPTV는 " + getIp() + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
	}

	public String getIp() {
		return ip;
	}
}

public class tr01 {

	public static void main(String[] args) {
		// ColorTV myTV = new ColorTV(32,1024);
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.printProperty();
	}
}
