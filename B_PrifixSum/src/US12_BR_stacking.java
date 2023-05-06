import java.util.*;
import java.io.*;

public class US12_BR_stacking {

	static BufferedReader in;
	static StringTokenizer st;		
	static PrintWriter out;
	static String f = "test";
	static int n, k, a[], ans;

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
		k = Integer.parseInt(st.nextToken());
		a = new int[n+2];
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken())+1;
			a[s]++;
			a[e]--;
		}
		System.out.println(Arrays.toString(a));

		for(int i=1; i<=n; i++)
			a[i]+=a[i-1];
		
		System.out.println(Arrays.toString(a));

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		ans = a[a.length/2+1];
		
		out.println(ans);
	}
	
	
}