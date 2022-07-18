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
		a = new ArrayList[n];
		v = new boolean[n];
		node = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) a[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y); 
			a[y].add(x);
		}		
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		for (int i = 0; i < n; i++){
			if(!v[i]){				
				node.add(i+1);
				dfs(i);
			}
		}
		
		System.out.println(node.size()-1);
		
		for (int i = 1; i < node.size(); i++){
			System.out.println(node.get(i-1) + " " + node.get(i));
		}
	}

	public static void dfs(int i){
		v[i] = true;
		for (int j: a[i])
			if(!v[j])
				dfs(j);
	}	
}