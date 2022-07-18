import java.io.*;
import java.util.*;

public class CSES1072 {

	static int n;
	static long ans, x, y;
	static BufferedReader in;
	static StringTokenizer st;
		
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();  //<----------
		ans = 0;
		for(long i=1;i<=n;i++) {
	        x = i*i*(i*i-1);
	        y = 4*((i-2)*(i-1) + (i-1)*(i-2));
	        ans = (x-y)/2;
			sb.append(ans).append("\n");
		}				
		System.out.println(sb.toString());	
	}
}
