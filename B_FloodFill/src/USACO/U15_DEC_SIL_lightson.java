package USACO;
import java.util.*;
import java.io.*;

public class U15_DEC_SIL_lightson {

	static BufferedReader in;
	static StringTokenizer st;		
	static PrintWriter out;

	static String f = "lightson";
	static int n, m, ans;
	static boolean v[][], on[][];
	static ArrayList<Integer>[][] a;
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1][n+1];
		for(int i=0; i<=n; i++) 
			for(int j=0; j<=n; j++)
				a[i][j] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			a[x][y].add(b);
			a[x][y].add(c);
		}
		
				
		v = new boolean[n+2][n+2];
		on = new boolean[n+2][n+2];		
		
	}


	static void solve() {
	
		on[1][1] = true;
		
		ff(1,1);		

		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				ans+= on[i][j]? 1:0;
		
		out.println(ans);
	}
	


	static void ff(int i, int j) {
	
		if(i<1||j<1||i>n||j>n||v[i][j]||!on[i][j]) return;
		
		v[i][j] = true;
		
		for(int k=0; k<a[i][j].size(); k+=2) {
			
			int x = a[i][j].get(k);
			int y = a[i][j].get(k+1);
			on[x][y] = true;
			
			if(v[x+1][y]||v[x-1][y]||v[x][y-1]||v[x][y+1]) ff(x,y);
		}
		
		ff(i, j+1);
		ff(i, j-1);
		ff(i+1, j);
		ff(i-1, j);
	}
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
}