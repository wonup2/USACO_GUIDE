import java.util.*;

public class CF546A {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		long w = in.nextLong();
		
		long sum = k*(w*(w+1)/2);
		
		System.out.println(sum-n > 0 ? sum-n : 0);
	}

}
