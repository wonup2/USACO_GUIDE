import java.io.*;
import java.util.*;

public class CSES1083 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
		long n = Long.parseLong(in.readLine());
		
		long sum = n*(n+1)/2; //<-----------------------------------------
		
		StringTokenizer st = new StringTokenizer(in.readLine()); //5 3 1 2
		
		n--;
		
		for(int i=0; i<n; i++) sum-=Integer.parseInt(st.nextToken());
		
		System.out.println(sum);
	}
}