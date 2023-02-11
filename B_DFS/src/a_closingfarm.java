

//2016 US Open Silver 3
import java.util.*;
import java.io.*;
public class a_closingfarm {
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	static int n, m;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("closing.in"));
		out = new PrintWriter("closing.out");
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n];
		for(int i = 0; i < n; i++) a[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			a[x].add(y);
			a[y].add(x);
		}		
	}

	static void solve() throws NumberFormatException, IOException {
		
		int start = 0;
		boolean[] closed = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			
			while(closed[start]) start++;			
			v = closed.clone();
			
			cnt = 0;			
			dfs(start);
			if(cnt == n - i) out.println("YES");
			else out.println("NO");
			
			closed[Integer.parseInt(in.readLine()) - 1] = true;
			
		}
		out.close();
	}
	
	static void dfs(int i) {
		v[i] = true;
		cnt++;
		for(int n: a[i]) 
			if(!v[n]) dfs(n);				
	}
}