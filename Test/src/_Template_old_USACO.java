import java.util.*;
import java.io.*;

public class _Template_old_USACO {

	static BufferedReader in;
	static StringTokenizer st;	
	
	static PrintWriter out;

	static String f = "test";
	static int n, a[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new File(f+".out"));
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {

		n = Integer.parseInt(in.readLine());
		a = new int[n];
		
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(in.readLine());
		Arrays.sort(a);
		
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int ans=0;
		for(int i=0; i<n; i++) {
			int left = check(i, -1);
			int right = check(i, 1);
			
			//System.out.println(i+" : " + left +" "+right);
			ans = Math.max(ans, left+right+1);
		}
		
		out.println(ans);
	}

	static int check(int i, int d) {
		
		int p = 1;
		int cnt = 0;
		
		while(i>=0 && i < n) {
			
			int next = i;

			while(true) {
				
				if(next + d <0 || next + d >=n || Math.abs(a[i]-a[next+d]) > p) break;
				
				cnt++;
				next = next + d;
			}

			if(i==next) break;
			p++;
			i = next;
		}
		
		return cnt;
	}
}