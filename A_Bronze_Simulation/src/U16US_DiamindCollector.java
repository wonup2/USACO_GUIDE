import java.util.*;
import java.io.*;

public class U16US_DiamindCollector {

	static Scanner in;
	static PrintWriter out;
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("diamond.in"));
		out = new PrintWriter(new File("diamond.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++)a[i] = in.nextInt();
		Arrays.sort(a);
	}
	
	static void solve() {
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=i; j<n; j++) {
		
				if(a[j]-a[i]<=k) cnt++;
			}
			max = Math.max(max, cnt);
		}
		
		out.println(max);
	}
}
