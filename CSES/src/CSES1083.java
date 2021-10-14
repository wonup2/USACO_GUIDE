import java.util.*;

public class CSES1083 {
 
	public static void main(String[] args)  {
		
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long sum = n*(n+1)/2;

		n--;

		while(n-->0) sum -= in.nextInt();
		
		System.out.println(sum);
	}
}