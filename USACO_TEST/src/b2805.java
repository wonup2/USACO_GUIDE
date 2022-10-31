import java.util.*;

public class b2805 {

	static Scanner in;
	static int n, m, low, high, mid, ans, a[];
	static long sum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		in = new Scanner(System.in);
		init();
		solve();

	}

	static void init() {
		n=in.nextInt();
		m=in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
	}
	static void solve() {
		
		low = 0;
		high = 46;
		
		while(low<high) {
			mid = (low+high)/2;

			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else high = mid-1;
			
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int mid) {
		sum = 0l;
		for(int i=0; i<n; i++) {
			
			if(a[i]>mid) sum+=a[i]-mid;
		}
		return sum>=m;
	}
}
/*
5 20
4 42 40 26 46
0 46 23
24 46 35
36 46 41
36 40 38
36 37 36
37 37 37
36

*/
