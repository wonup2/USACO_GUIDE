import java.util.Scanner;

public class Kattis_BasketBall {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String s = in.next();
		
		System.out.println(s.charAt(s.length()-2));
		//A2B1A2B2A1A2A2A2  ---> A
		
		in.close(); 
	}
}