import java.util.*;
import java.io.*;

public class CF1826RunningMiles {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, l[], r[], a[], ans;
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solve() {
		l = new int[n];
		r = new int[n];
		
		l[0] = a[0];
		r[n-1] = a[n-1]-(n-1);
		for(int i=1; i<n; i++) l[i] = Math.max(l[i-1], a[i]+i);			
		for(int i=n-2; i>=0; i--) r[i] = Math.max(r[i+1], a[i]-i);			

		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(l));
		//System.out.println(Arrays.toString(r));

		for(int i=1; i<n-1; i++) {
			int num = l[i-1] + a[i] + r[i+1];
			ans = Math.max(ans, num);
		}
		
		System.out.println(ans);
	}
	
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());

		while(t-->0) {
			ans = 0;
			init();
			solve();
		}
	}

}

/*

1
7
3 1 9 2 8 4 10

*/
