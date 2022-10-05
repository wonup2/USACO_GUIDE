import java.util.*;

public class CSES1623AppleDivision {

	static Scanner in;
	static int n;
	static long a[];
	static boolean[] b;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt();
		a = new long[n];
		for(int i=0; i<n; i++)
			a[i] = in.nextLong();
	}

	static void solve() {
		
	
		long min = Long.MAX_VALUE;
		
		int num = (int)Math.pow(2, n);
		String bin = "";

		for(int i=0; i<num; i++) {
			
			bin = Integer.toBinaryString(i);
			b = new boolean[n];
			
			for(int j=0; j<bin.length(); j++) 
				b[n-j-1]= bin.charAt(j)=='1'? true:false;			
			
			long x = 0l, y=0l;
			for(int j=0; j<b.length;j++) {
				if(b[j]) x+=a[j];
				else y+=a[j];
			}
			
			min = Math.min(min, Math.abs(x-y));
		}
		
		System.out.println(min);
	}
}
