import java.util.*;
import java.io.*;

public class CSES1754 {
	static BufferedReader in;
	static int n, a, b;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(n-->0) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if((a+b)%3==0 && Math.max(a,b)<=2*Math.min(a, b)) 
				sb.append("YES").append("\n");
			else 
				sb.append("NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
