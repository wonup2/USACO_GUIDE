import java.util.*;
import java.io.*;

public class U19_SIL_revegetate{

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, m, ans, pastures[];
	static ArrayList<Integer>[] s, d;
	static boolean no;
	
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
		m = Integer.parseInt(st.nextToken());
		
		s = new ArrayList[n+1];
		d = new ArrayList[n+1];
        Arrays.setAll(s, i -> new ArrayList<>());
        Arrays.setAll(d, i -> new ArrayList<>());
		
        pastures = new int[n+1];
		
		int a, b;
		char c;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			c = st.nextToken().charAt(0);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
				
			if(c=='S') {
				s[a].add(b);
				s[b].add(a);
			}
			else {
				d[a].add(b);
				d[b].add(a);
			}
		}
		
		//System.out.println(Arrays.toString(L));
		//System.out.println(Arrays.toString(s));
		//System.out.println(Arrays.toString(d));

	}
	
	static void solve() {
		
		for(int i=1; i<=n; i++) {
			if(pastures[i]==0) {
				dfs(i,1);
				ans++;
			}
		}
		
		//System.out.println(Arrays.toString(L));
		
		StringBuilder sb = new StringBuilder();
		if(no) out.println(0);
		else {
			sb.append("1");
			for(int i=0; i<ans; i++) sb.append("0");	
			out.println(sb.toString());
			
		}		
	}
	
	static void dfs(int cur, int seed) {
		
		pastures[cur] = seed;
		
		for(int next:s[cur]) {
			if(pastures[next]==seed*-1) no = true;
			if(pastures[next]==0) dfs(next, seed);
		}
		
		for(int next:d[cur]) {
			if(pastures[next]==seed) no = true;
			if(pastures[next]==0) dfs(next, seed*-1);
		}		
	}
}