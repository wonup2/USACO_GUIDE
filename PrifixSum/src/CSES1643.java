import java.util.*;
import java.io.*;

public class CSES1643 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static long a[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new long[n];
	}
	
	
	static void solve() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		a[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) 
			a[i] =  Integer.parseInt(st.nextToken());

		long ans = a[0];
		long max = -1000000001;
		
		for(int i=1; i<n; i++) {
			
			if(ans + a[i] < a[i]) ans = a[i];			
			else ans += a[i];
			//a[i] = Math.max(a[i], a[i]+a[i-1]); //Kadane's Algorithm
			max = Math.max(max,ans);
		}
		
		max = Math.max(max,ans);
		System.out.println(max);
	}

}
