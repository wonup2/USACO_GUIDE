package USACO;
// Solution to 2016 December USACO Silver Problem: Moocast

import java.util.*;
import java.io.*;

public class B_moocast{

	public static int n, cnt, x[], y[], p[];
	public static boolean[] v;
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("moocast.in"));
		PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
		
		//input
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		p = new int[n];

		for (int i=0; i<n; i++)	{		
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		
		//processing
		int res = 0;
		for (int i=0; i<n; i++) {
			
			v = new boolean[n]; 
			cnt=1;
			
			dfs(i);
			
			res = Math.max(res, cnt);
			
		}

		//output
		out.println(res);
		out.close();
		in.close();
	}

	public static void dfs(int i) {
		v[i] = true;

		for (int j=0; j<n; j++) {
			if (i==j || v[j]) continue;

			long dist = (x[j] - x[i])*(x[j] - x[i]) + (y[j] - y[i])*(y[j] - y[i]);
			long pow = p[j]*p[j];
			
			if (dist <= pow) { 
				dfs(j); 
				cnt++;
			}
		}
	}
}