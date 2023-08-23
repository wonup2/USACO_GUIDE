import java.util.*;
import java.io.*;

public class CF1176E_coverit{

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static int t, n, m, node[];
	static ArrayList<Integer>[] a;
	static boolean v[];
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		

		a = new ArrayList[n+1];
        Arrays.setAll(a, i -> new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());							
			a[u].add(v);
			a[v].add(u);
		}
				
		node = new int[n+1];
		v = new boolean[n+1];
	}
	

	static void solve() {
		
		dfs(1, 1);
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		int cnt1=0, cnt2=0;
		for(int i=1; i<=n; i++) {
			if(node[i]==1) {
				sb1.append(i).append(" ");
				cnt1++;
			}
			else {
				sb2.append(i).append(" ");
				cnt2++;
			}
		}

		if(cnt1 <= n/2) {
			System.out.println(cnt1);
			System.out.println(sb1.toString());
		}
		else {
			System.out.println(cnt2);
			System.out.println(sb2.toString());
		}
	}
	
	static void dfs(int i, int c) {
		v[i] = true;
		node[i] = c;
		
		for(int next:a[i]) {
			if(v[next]) continue;
			dfs(next, c*-1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		while(t-->0) {
			init();
			solve();
		}
		in.close();
	}
	
	
	
}