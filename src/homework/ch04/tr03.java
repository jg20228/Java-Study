package homework.ch04;


class Song{
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song(String title, String artist, int year, String country) {
		this.title=title;
		this.artist=artist;
		this.year=year;
		this.country=country;
	}
	
	public void show() {
		System.out.println(title);
		System.out.println(artist);
		System.out.println(year);
		System.out.println(country);
	}
}


public class tr03 {
	public static void main(String[] args) {
		Song song = new Song("Dancing Queen","ABBA",1978,"½º¿þµ§");
		song.show();
	}
}
