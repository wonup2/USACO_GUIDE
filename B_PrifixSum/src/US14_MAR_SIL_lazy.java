// Arup Guha
// 12/18/2019
// Solution to 2014 March USACO Silver Problem: The Lazy Cow (Silver version)

import java.util.*;
import java.io.*;

public class US14_MAR_SIL_lazy {
	static BufferedReader in;	
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k, a[][];
	
	public static void main(String[] args) throws Exception {
		
		in = new BufferedReader(new FileReader("lazy.in"));
		out = new PrintWriter(new FileWriter("lazy.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// We'll rotate everything 45 degrees, so it'll be stored in a bigger grid.
		// Basically (x, y) -> (x+y+1, x-y+n). 
		// Then, the area we are looking for is a square, not a diamond.
		a = new int[2*n+1][2*n+1];
		
		// Read in the grid, directly into the mapped location.
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j=0; j<n; j++) 
				a[i+j+1][i-j+n] = Integer.parseInt(st.nextToken());			
		}
		print(a);
	}
	
	static void solve() {
		
		// Remap k for this new grid size 1->3, 2->5, etc.
		k = Math.min(2*k+1, 2*n);
		
		// Do cumulative sums for each row.
		for (int i=1; i<a.length; i++)
			for (int j=1; j<a.length; j++)
				a[i][j] += a[i][j-1] + a[i-1][j] - a[i-1][j-1];
				
		// And then for the columns.
		//for (int j=0; j<a.length; j++)
		//	for (int i=1; i<a.length; i++)
		//		a[i][j] += a[i-1][j];
		
		print(a);
	//	System.out.println(Arrays.deepToString(vals));
		
		int res = 0;
				
		// Now, each box sum is just the sum and difference of full rectangle sums (from top left).
		for (int i=0; i+k<a.length; i++) {
			for (int j=0; j+k<a.length; j++) {
				int cur = a[i+k][j+k] - a[i][j+k] - a[i+k][j] + a[i][j];
				res = Math.max(res, cur);
			}
		}
		out.println(res);
		
	}
	
	static void print(int[][] a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
			
		}
	}
}