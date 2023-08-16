import java.io.*;
import java.util.*;

public class B9576_book {

	static List<Integer>[] a;
	static boolean[] v;
	static int t, n, m, b[];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws  IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[m+1];
		
		for(int i=1; i<=m; i++) 
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=x; j<=y; j++) 
				a[i].add(j);
		}
		
		v = new boolean[n+1];
		b = new int[n+1];				
	}
	
	static void solve() {
		
		int cnt = 0;		
		for(int i=1; i<=m; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) cnt++; 
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int st) {
		
		for(int i : a[st]) {
			
			if(v[i]) continue;
			v[i]=true;
			if(b[i]==0 || dfs(b[i])) {
				b[i] = st;
				return true;
			}
		}
		
		return false;
	}
}