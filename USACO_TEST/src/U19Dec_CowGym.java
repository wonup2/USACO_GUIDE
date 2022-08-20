import java.util.*;
import java.io.*;

public class U19Dec_CowGym {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int k, n, a[][], win, ans;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		a = new int[k][n];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][Integer.parseInt(st.nextToken())-1] = j;
			}
		}
		
		System.out.println(Arrays.deepToString(a));
	}
	
	static void solve() {
		
		ans = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				win = 0;
				for(int r=0; r<k; r++) {
					if(a[r][i] < a[r][j]) win++;
				}
				if(win==0 || win==k) ans++;
			}
		}
		
		out.println(ans);
		
	}

}