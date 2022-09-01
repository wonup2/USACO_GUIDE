import java.util.*;


public class CSES1068WeirdAlgorithm {

	static Scanner in;
	
	static long n;
	
	public static void main(String[] args) {

			
		in = new Scanner(System.in);
		
		n = in.nextLong();

		System.out.print(n);
		
		while(n!=1) {
			
			if(n%2==0) n = n/2;
			else n = n*3 +1;
			
			System.out.print(" "+n);
		}
	}
	
}
