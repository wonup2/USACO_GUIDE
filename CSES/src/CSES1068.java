import java.io.*;
import java.util.*;

public class CSES1068 {

	static BufferedReader in;
	static long n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(in.readLine());				
		
		StringBuilder sb = new StringBuilder();  //<----------
		sb.append(n);
		
		while(n!=1) {
			if(n%2==0) n /= 2;				
			else n = n*3 +1;	
			sb.append(" ").append(n);
		}
		
		System.out.println(sb.toString());	

	}
}
