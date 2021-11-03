import java.util.*;
import java.io.*;

public class CSES1661 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, x;
	static long ans, a[];
	static HashMap<Long, Integer> m;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();		
		in.close();
	}
	
	static void init() throws IOException {	
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		a = new long[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) a[i] = a[i-1] + Long.parseLong(st.nextToken());
		m = new HashMap<Long, Integer>();
		
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() throws IOException {
		
		for(int i = 0; i<=n; i++) {
			//System.out.println(m);
			long f = a[i]-x;  //System.out.println(f);
			if(m.containsKey(f)) ans += m.get(f);
				
			if(m.containsKey(a[i])) m.put(a[i], m.get(a[i])+1);		
			else m.put(a[i], 1);
		}
		
		System.out.println(ans);
	}

}
