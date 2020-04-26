package homework.ch03;

public class Train13 {

	public static void main(String[] args) {
		int i = 0;
		int count=0;
		while(true) {
			i++;
			count=i/10;
			
			if(count==3||count==6||count==9) {
				System.out.print(i+"¹Ú¼ö Â¦");
				if(i%3==0) {
					System.out.print("Â¦");
				}
				System.out.println();
			}else if(i%3==0) {
				System.out.println(i+"¹Ú¼ö Â¦");
			}
			if(i>=100) {break;}
		}
	}
}
