import java.util.*;
import java.io.*;

public class CSES1661 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static long x, p[];
	static HashMap<Long, Integer> seen;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws IOException {	
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Long.parseLong(st.nextToken());
		p = new long[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<n+1; i++) p[i] = p[i-1] + Long.parseLong(st.nextToken());
		
		seen = new HashMap<Long, Integer>();
		//System.out.println(Arrays.toString(p));
	}
	
	static void solve() throws IOException {

		for(int i = 0; i<n+1; i++) {
			//2
			
			
			//3
		}
		
	}

}
