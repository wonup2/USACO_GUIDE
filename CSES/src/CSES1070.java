import java.io.*;
import java.util.*;

public class CSES1070 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder st = new StringBuilder();
		
		if(n==1) st.append("1");
		
		else if(n<=3) st.append("NO SOLUTION");

		else {
			
			for (int i = 2; i <= n; i += 2)
				st.append(i).append(" ");
			
		    for (int i = 1; i <= n; i += 2)
		    	st.append(i).append(" ");
		}
		
		System.out.println(st.toString());
	}
}
