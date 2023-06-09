import java.util.*;
import java.io.*;

public class US17_SIL_maxacross {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k, b, ans;
	static int a[], p[];
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("test.in"));
		out = new PrintWriter(new File("test.out"));
		init();
		solve();		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		a = new int[n+1];
		p = new int[n+1];
		
		Arrays.fill(a, 1);
		for(int i=0; i<b; i++) a[Integer.parseInt(in.readLine())] = 0;
		
		System.out.println(Arrays.toString(a));
		
		for(int i=1; i<=n; i++) p[i] = p[i-1] + a[i];
		
		System.out.println(Arrays.toString(p));
	}

	static void solve() throws IOException {
		
		ans = Integer.MAX_VALUE;
		
		for(int i=k; i<=n; i++) 			
			ans = Math.min(ans, k-(p[i]-p[i-k]));		
		
		out.println(ans);
	}
}
