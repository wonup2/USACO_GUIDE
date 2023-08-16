import java.io.*;
import java.util.*;

public class B11375_work {

	static List<Integer>[] a;
	static boolean[] v;
	static int n, m, s, b[];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws  IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(Arrays.toString(b));
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) 
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			for(int j=1; j<=s; j++) a[i].add(Integer.parseInt(st.nextToken()));
		}
		
		v = new boolean[m+1];
		b = new int[m+1];
	}
	
	static void solve() {
		
		int cnt = 0;
		
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) cnt++; 
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int cow) {
		
		for(int i : a[cow]) {
			
			if(v[i]) continue;
			v[i]=true;
			if(b[i]==0 || dfs(b[i])) {
				b[i] = cow;
				return true;
			}
		}
		
		return false;
	}
}