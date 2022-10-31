
import java.util.*;

public class B28051 {

	static Scanner in;
	static int n, k, ans, high, low, mid, a[];
	
	public static void main(String[] args) {

		in = new Scanner (System.in);
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt();
		k = in.nextInt();
		
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
	}

	static void solve() {
		
		
		low = 0;
		high = 1000000000;
		
		ans = 0;
		
		while(low <= high) {
			
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int mid) {
		long sum = 0;
		
		for(int i=0; i<n; i++) {
			
			if(a[i] > mid)
				sum += (a[i] - mid);
		}
		
		return sum >= k;
		
	}
}
