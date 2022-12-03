import java.util.*;
import java.io.*;

public class U19Jan_SleepyCowSorting {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, a[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(in.readLine());

		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=n-1; i>0; i--) {
			if(a[i] < a[i-1]) {
				ans = i;
				break;
			}
		}
		
		out.println(ans);
	}

}