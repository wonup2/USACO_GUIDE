import java.io.*;
import java.util.*;

public class CSES1094 {
	
	static int p, c, n;
	static long ans;
	static BufferedReader in;
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		p = 0;
		c = 0;
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		while(n-->0) {
			c = Integer.parseInt(st.nextToken());
			if(p>c) ans+=p-c;
			else p=c;
		}
		
		System.out.println(ans);		
	}
}
