import java.util.*;
import java.io.*;

public class AC_GCDBlackboard {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, ans, pre[], suf[], a[];
	
	static int gcd(int a, int b) {
		
		if(b==0) return a;
		else return gcd(b, a%b);
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		pre = new int[n];
		suf = new int[n];
		
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		pre[0] = a[0];
		suf[n-1] = a[n-1];
		
		for(int i=1; i<n; i++) pre[i] = gcd(pre[i-1], a[i]);
		for(int i=n-2; i>=0; i--) suf[i] = gcd(suf[i+1], a[i]);
	}
	
	static void solve() {
		
		ans = suf[1];
		for(int i=1; i<n; i++) {
			if(i==n-1) ans = Math.max(ans, pre[i-1]);
			else ans = Math.max(ans, gcd(pre[i-1], suf[i+1]));
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException{

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	
	
	}

}
