import java.util.*;
import java.io.*;

public class GCDonBlackboard {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, l[], r[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));		
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		n = Integer.parseInt(in.readLine());
		l = new int[n];
		r = new int[n];	
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) l[i] = r[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solve() throws IOException {

		for(int i = 1; i < n; i++) l[i] = gcd(l[i], l[i-1]);
		for(int i = n-2; i >=0; i--) r[i] = gcd(r[i], r[i+1]);
		
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(r));
		
		int ans = r[1];
		for(int i = 1; i < n-1; i++) {			
			int temp = gcd(l[i-1], r[i+1]);
			ans = Math.max(temp, ans);
		}
		
		ans = Math.max(l[n-2], ans);
		System.out.println(ans);
	}

	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}
