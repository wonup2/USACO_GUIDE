import java.util.*;
import java.io.*;

public class Stuck_in_aRuck {

	static Scanner in;
	//static BufferedReader in;
	static StringTokenizer st;
	static int n, d[], x[], y[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);		
		//in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws IOException {	
		
		n = in.nextInt();
		d = new int[n];
		x = new int[n];
		y = new int[n];
		
		for(int i=0; i<n; i++) {
			d[i] = in.next().charAt(0)=='E'? 0:1;
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));

		
	}
	
	/*
6
E 3 5
N 5 3
E 4 6
E 10 4
N 11 2
N 8 1
	 */
	static void solve() throws IOException {
		
		for(int i=0; i<n; i++) {
			int ans = check(i);
			if(ans== Integer.MAX_VALUE) System.out.println("Infinity");
			else System.out.println(ans);
		}
	}	
	
	static int check(int i) {
		
		int min = Integer.MAX_VALUE;
		
		for(int j=0; j<n; j++) {
			
			if(i==j || d[i]==d[j]) continue;
			
			if(d[i]==0) {
				
				if(x[i] > x[j] || y[i] < y[j]) continue;
				int dx = x[j]-x[i];
				int dy = y[i]-y[j];
				
				if(dx > dy && check(j) > dy) min = Math.min(dx, min);
				
			}
			
			else {
				if(x[i] < x[j] || y[i] > y[j]) continue;
				int dx = x[i]-x[j];
				int dy = y[j]-y[i];
				
				if(dy > dx && check(j) > dx) min = Math.min(dy, min);
			}
		}
		
		return min;
		
	}
}
