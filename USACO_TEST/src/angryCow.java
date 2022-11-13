import java.util.*;
import java.io.*;

public class angryCow {

	static BufferedReader in;
	static PrintWriter out;
	static int n, k, a[];
	static String file = "test";
	public static void main(String[] args)throws IOException {

		in = new BufferedReader(new FileReader(file+".in"));
		out = new PrintWriter(new FileWriter(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(in.readLine());
		Arrays.sort(a);
	}
	
	static void solve() {
		
		int low = 0;
		int high = 500000000;
		int mid = 0;
		int ans = 0;
		while(low<=high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		out.println(ans);
		
	}

	static boolean check(int mid) {
		
		int start = a[0];
		int cow = 1;
		
		for(int i=0; i<n; i++) {
			if(a[i] - start > mid * 2) {
				cow++;
				start = a[i];
			}
		}
		
		return cow <= k;
	}
}
