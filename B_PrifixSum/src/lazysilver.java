// Arup Guha
// 12/18/2019
// Solution to 2014 March USACO Silver Problem: The Lazy Cow (Silver version)

import java.util.*;
import java.io.*;

public class lazysilver {

	public static void main(String[] args) throws Exception {
		
		BufferedReader stdin = new BufferedReader(new FileReader("lazy.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		
		// We'll rotate everything 45 degrees, so it'll be stored in a bigger grid.
		// Basically (x, y) -> (x+y+1, x-y+n). 
		// Then, the area we are looking for is a square, not a diamond.
		int[][] vals = new int[2*n+1][2*n+1];
		
		// Read in the grid, directly into the mapped location.
		for (int i=0; i<n; i++) {
			tok = new StringTokenizer(stdin.readLine());
			for (int j=0; j<n; j++) {
				vals[i+j+1][i-j+n] = Integer.parseInt(tok.nextToken());
				//System.out.println(i+ " "+j + " : "+(i+j+1)+" "+(i-j+n));
			}
		}
		print(vals);
		
		// Remap k for this new grid size 1->3, 2->5, etc.
		k = Math.min(2*k+1, 2*n);
		
		// Do cumulative sums for each row.
		for (int i=0; i<vals.length; i++)
			for (int j=1; j<vals.length; j++)
				vals[i][j] += vals[i][j-1];
				
		// And then for the columns.
		for (int j=0; j<vals.length; j++)
			for (int i=1; i<vals.length; i++)
				vals[i][j] += vals[i-1][j];
		
	//	print(vals);
	//	System.out.println(Arrays.deepToString(vals));
		
		int res = 0;
				
		// Now, each box sum is just the sum and difference of full rectangle sums (from top left).
		for (int i=0; i+k<vals.length; i++) {
			for (int j=0; j+k<vals.length; j++) {
				int cur = vals[i+k][j+k] - vals[i][j+k] - vals[i+k][j] + vals[i][j];
				res = Math.max(res, cur);
			}
		}

		// Output to file.
		PrintWriter out = new PrintWriter(new FileWriter("lazy.out"));
		out.println(res);
		out.close();		
		stdin.close();
	}
	
	static void print(int[][] a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
			
		}
	}
}