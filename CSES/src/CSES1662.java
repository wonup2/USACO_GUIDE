import java.util.*;
import java.io.*;

public class CSES1662 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, MAX = 200001;
	static long cnt;
	static HashMap<Long, Integer> seen;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		n = Integer.parseInt(in.readLine());
		seen = new HashMap<Long, Integer>();
		seen.put(0l, 1);
	}
	
	static void solve() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		long sum = 0l;

		for(int i=0; i<n; i++) {
			long num = Long.parseLong(st.nextToken());
			sum += num % n; 
			sum = (sum+n) % n;  

			if(seen.containsKey(sum)) {
				cnt+=seen.get(sum);
				seen.put(sum, seen.get(sum)+1);
			}
			else seen.put(sum,1);
		}
		
		System.out.println(cnt);
	}
}

/*
11
2 1 -3 2 -7 7 -2 6 9 -4 10

*/

