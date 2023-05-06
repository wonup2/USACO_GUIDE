import java.util.*;

public class B2042_RangeSum {
	
	static Scanner in;
	static int n, m, k;
	static long a[];
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt()+in.nextInt();
	
		
		a = new long[n+1];
		for(int i=1; i<=n; i++)a[i] = in.nextLong();
		
		for(int i=1; i<=n; i++) {
			int next = i+(i&-i);
			if(next<=n) a[next] += a[i];
		}
		
		while(m-->0) solve();
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int a = in.nextInt();
		int b = in.nextInt();
		long c = in.nextInt();
		
		if(a==1) update(b, c);
		else System.out.println(sum(b, (int)c));		
	}
	
	static void update(int i, long c) {
		
		//long num = k-a[i];
		
		while(i<=n) {
			a[i] += 1;
			i += (i&-i);
		}
	}
	
	static long prefixSum(int i) {
		
		long sum = 0l;
		
		while(i!=0) {
			
			sum+=a[i];
			i-=(i&-i);
		}
		return sum;
	}



	static long sum(int i, int j) {
		
		return prefixSum(j) - prefixSum(i-1);
	}
	
	
}
