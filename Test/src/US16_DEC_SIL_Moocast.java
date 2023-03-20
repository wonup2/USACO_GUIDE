import java.util.*;
import java.io.*;

public class US16_DEC_SIL_Moocast {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, x[], y[], p[], cnt;
	static boolean v[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		//st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(in.readLine());
		x = new int[n];
		y = new int[n];
		p = new int[n];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			v = new boolean[n];
			cnt=1;
			dfs(i);
			max = Math.max(cnt, max);
		}
		
		System.out.println(max);
	}

	static void dfs(int i) {
		
		v[i] = true;
		
		for(int j=0; j<n; j++) {
			if(i==j || v[j]) continue;
			
			long dist = (x[j] - x[i])*(x[j] - x[i]) + (y[j] - y[i])*(y[j] - y[i]);
			long pow = p[j]*p[j];
			
			if (dist <= pow) { 
				dfs(j);
				cnt++;
			}
		}
	}
}