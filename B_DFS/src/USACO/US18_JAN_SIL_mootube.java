package USACO;

import java.io.*;
import java.util.*;

public class US18_JAN_SIL_mootube {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, q, ans;
	static LinkedList<pair>[] a;
	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("mootube.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));		
		init();
		solve();		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
			
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new LinkedList[n];
		for(int i = 0; i < n; i++) a[i] = new LinkedList<pair>();		
				
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			a[x].add(new pair(y, w));
			a[y].add(new pair(x, w));
		}	
		
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() throws IOException {
		
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken())-1;
			ans = 0;
			v = new boolean[n];

			dfs(j, k);
			
			out.println(ans);
		}
		out.close();
	}
	
	static void dfs(int i, int k) {
		v[i] = true;
		
		for(pair e:a[i]) {
			if(v[e.d]) continue;
			if(e.w >= k) {
				ans++;
				dfs(e.d, k);
			}
		}
	}
	
	static class pair {
		public int d, w;
		public pair(int a, int b) {
			d=a;
			w=b;
		}
		public String toString() {
			return d+" "+w;
		}
	}
		
}