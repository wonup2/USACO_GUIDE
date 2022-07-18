package CSES;


import java.util.*;
import java.io.*;

public class CSES1666{
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer> a[], node;
	static boolean v[];
	static int n, m;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n+1];
		v = new boolean[n+1];
		node = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) a[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y); 
			a[y].add(x);
		}		
	}
	
	static void solve() {
		
		for (int i = 1; i < a.length; i++){
			if(!v[i]){				
				node.add(i);
				dfs(i);
			}
		}
		
		System.out.println(node.size()-1);
		
		for (int i = 1; i < node.size(); i++){
			System.out.println(node.get(i-1) + " " + node.get(i));
		}
		System.out.close();
	}

	public static void dfs(int i){
		v[i] = true;
		for (int j: a[i])
			if(!v[j])
				dfs(j);
	}	
}