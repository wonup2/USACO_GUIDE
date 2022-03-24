import java.util.*;
import java.io.*;

public class RectangularPasture {
	
	static Scanner in;
	static int n, a[][], x[], y[];
	static TreeMap<Integer, Integer> xp, yp;  //concentrate

	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		xp = new TreeMap<Integer, Integer>();
		yp = new TreeMap<Integer, Integer>();
	
		a = new int[n+1][n+1];
		x = new int[n];
		y = new int[n];	
				
		//concentrate & rearrange
		for(int i=1; i<=n; i++) {
			xp.put(in.nextInt(), i);
			yp.put(in.nextInt(), i);
		}			
		int order = 1;
		for(int i:xp.values()) x[i-1]=order++;
		order = 1;
		for(int i:yp.values()) y[i-1]=order++;							
		for(int i=0;i<n; i++) a[x[i]][y[i]]++;		
	}
		
	static void solve() {
		//prefix sum
		for(int i=1;i<=n; i++) {
			for(int j=1; j<=n; j++) {
				a[i][j] += a[i-1][j]+a[i][j-1]-a[i-1][j-1];
			}
		}
		
		//check every coordinate 
		long ans = n+1;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int mx = Math.min(x[i], x[j]);
				int Mx = Math.max(x[i], x[j]);
				int my = Math.min(y[i], y[j]);
				int My = Math.max(y[i], y[j]);
				
				ans += sum(mx, 1, Mx, my) * sum(mx, My, Mx, n);
			}
		}
		
		System.out.println(ans);
	}

	static int sum(int x1, int y1, int x2, int y2) {
		return a[x2][y2] - a[x2][y1-1] - a[x1-1][y2] + a[x1-1][y1-1];
	}
}
