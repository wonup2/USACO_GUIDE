import java.io.*;
import java.util.*;


public class U16Dec_MowingTheField {
	
	static Scanner in;
	static PrintWriter out;
	static int a[][], n, s, dx, dy, cx, cy, t;
	static char d;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("mowing.in"));
		out = new PrintWriter(new FileWriter("mowing.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {		
		
		a = new int[2001][2001];
		
		cx = 1000;
		cy = 1000;
		a[cx][cy] = 0;
		t = 0;
		
		n = in.nextInt();
	}
	
	static void solve() {	

		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			
			d = in.next().charAt(0);
			dx = 0;
			dy = 0;
			if(d == 'N') dx = -1;
			else if(d == 'S') dx = 1;
			else if(d == 'W') dy = -1;
			else dy = 1;
			
			s = in.nextInt();
			
			for(int j = 0; j < s; j++) {
				cx += dx;
				cy += dy;
				t++;

				if(a[cx][cy] > 0) ans = Math.min(t - a[cx][cy], ans);
			
				a[cx][cy] = t;
			}
		}
		
		if(ans == Integer.MAX_VALUE) ans = -1;

		out.println(ans);	
	}
}