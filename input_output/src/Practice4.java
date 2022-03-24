
import java.util.*;


public class Practice4 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input numbers: ");
		
		String s = in.nextLine();
		
		StringTokenizer st = new StringTokenizer(s); //<----------------------
		
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		System.out.println("Total sum is " + sum);		
				
	}
}

//1 2 3 4 5 6 7
