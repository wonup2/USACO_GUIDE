package CSES;

import java.util.*;
import java.io.*;

public class CSES1672 {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, q;
	static long d[][];
	static long INF = Long.MAX_VALUE/2;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();	
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		d = new long[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				d[i][j] = INF;
			}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());

			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			long w = Long.parseLong(st.nextToken());
			if(d[r][c]>w) {
				d[r][c] = w;
				d[c][r] = w;
			}
		}
		
	}
	static void solve() throws IOException {
		
		for(int i = 0; i<n; i++) 
			for(int s = 0; s<n; s++) 
				for(int e = 0; e<n; e++) 
					d[s][e] = Math.min(d[s][i] + d[i][e] ,  d[s][e]);	

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());

			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			if(d[r][c] == INF) sb.append(-1);
			else sb.append(d[r][c]);
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static void fw() {
		
		
				
			
	}
}

/*

4 3 5
1 2 5
1 3 9
2 3 3
1 2
2 1
1 3
1 4
3 2

*/
