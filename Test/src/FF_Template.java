/*
3 4
1 1 2 1
2 3 2 1
1 3 3 3

*/

import java.util.*;
import java.io.*;

public class FF_Template {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, a[][], ans;
	static boolean v[][];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		v = new boolean[n][m];
		
		for(int i=0; i<n; i++) 
			a[i] = Arrays.stream(in.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
		
		System.out.println(Arrays.deepToString(a));
	}

	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!v[i][j]) {
					ans++;
					ff(i, j, a[i][j]);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void ff(int i, int j, int c) {
		
		if(i<0||j<0||i>=n||j>=m||c!=a[i][j]||v[i][j]) return;
		
		v[i][j] = true;
		
		ff(i, j+1, c);
		ff(i, j-1, c);
		ff(i+1, j, c);
		ff(i-1, j, c);
		
	}
}
