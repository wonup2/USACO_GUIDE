package USACO;

import java.util.*;
import java.io.*;

public class US16_OP_SIL_closing {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, m, cnt;
	static ArrayList<Integer>[] a;
	static boolean closed[], v[];

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
		a = new ArrayList[n];
		
		for(int i=0; i<n; i++)a[i] = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}
		
		closed = new boolean[n];
		v = new boolean[n];
	}
	
	static void solve() throws NumberFormatException, IOException {
		
		int start = 0;
		
		for(int i=0; i<n; i++) {
			v = closed.clone();
			while(closed[start]) start++;
			
			cnt = 0;
			dfs(start);
			if(n-i==cnt) out.println("YES");
			else out.println("NO");
			
			closed[Integer.parseInt(in.readLine())-1]=true;
		}
	}
	
	static void dfs(int s) {
		
		v[s] = true;
		cnt++;
		
		for(int i:a[s]) {
			if(!v[i]) dfs(i);
		}
	}

}