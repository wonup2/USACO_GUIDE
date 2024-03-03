package Baekjun;
import java.util.*;
import java.io.*;

public class B2805_tree {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, m;
	static long a[];
	static long ans, high, mid, low;
	
	
	static boolean check(long mid) {
		
		long s = 0;
		
		for(int i = 0; i < n; i++) {
			s += a[i] - mid > 0 ? a[i] - mid: 0;
			
		}
		//processing
		
		
		return s >= m; //differ according to case
	}
	
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new long[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		

	}
	
	
	static void solve() {
		Arrays.sort(a);
		low = 0;
		high = a[n - 1];
		while(low <= high) {
			mid = (low + high) /2;
			
			if(check(mid)) {
				ans = mid;
				low = mid +1;
			}
			else {
				high = mid -1;
			}
		}
		System.out.println(ans);
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

}