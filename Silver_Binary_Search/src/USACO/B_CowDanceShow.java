package USACO;

import java.io.*;
import java.util.*;

public class B_CowDanceShow {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int N, TMax, ans, cows[];	

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader ("cowdance.in"));
		out = new PrintWriter (new File ("cowdance.out"));
		init();
	    solve();
	    out.close();
	    in.close();	    
	}
	
	public static void init () throws IOException {

		st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		TMax = Integer.parseInt(st.nextToken());
		cows = new int [N];
		for (int i = 0; i < N; i++) 
			cows[i] = Integer.parseInt(in.readLine());
				
	}
	
	public static void solve () {
		
		int low = 1;    //<-----
		int high = N;	//<-----
		int mid = 0;
		
		while (low <= high) {			
			mid = (low + high)/2;
			if (f (mid)) {
				ans = mid;
				high = mid - 1;		//<-----		
			}
			else low = mid + 1;		//<-----	
		}
		out.println(ans);		
	}
	
	public static boolean f(int mid) {
		
		PriorityQueue<Integer> stage = new PriorityQueue<Integer>();
		
		for (int i = 0; i < mid; i++) stage.add(cows[i]);		
		
		for (int i = mid; i < N; i++) {
			if (stage.peek() + cows[i] > TMax) return false;			
			stage.add(cows[i]+stage.poll());
		}
		return true;		
	}
}
