import java.util.*;
import java.io.*;

public class US19_SIL_paintbarn {

	static BufferedReader in;
	static StringTokenizer st;		
	static PrintWriter out;
	static String f = "paintbarn";
	static int n, k, a[][], ans;

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
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[1001][1001];
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<n; i++) marking();
		
		countK();
		
		out.println(ans);
	}
	
	static void marking() throws IOException {
		st = new StringTokenizer(in.readLine());

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		for(int i=c1; i<c2; i++) {
			a[r1][i]++;
			a[r2][i]--;
		}
	}

	static void countK() {
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<=1000; j++) {
				if(a[i][j]==k) ans++;
				a[i+1][j]+=a[i][j];
			}
		}
	}
}