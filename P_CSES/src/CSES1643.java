import java.util.*;
import java.io.*;

public class CSES1643 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static long p[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		p = new long[n+1];
	
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) p[i] =  Long.parseLong(st.nextToken());
	}
	
	
	static void solve() throws IOException {

		long max = -1000000001;
		
		for(int i=1; i<=n; i++) {

			p[i] = Math.max(p[i], p[i]+p[i-1]); //Kadane's Algorithm			
			max = Math.max(max,p[i]);
		}
		
		System.out.println(max);
	}

}
