import java.util.*;

public class U20BDec_StuckRut {
	static Scanner in;
	static int n, x[], y[];
	static char d[];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}

	static void init() {
		
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		d = new char[n];
		
		for(int i=0; i<n; i++) {
			d[i] = in.next().charAt(0);
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			int ans = check(i);
			
			if(ans == Integer.MAX_VALUE) System.out.println("Infinity");
			else System.out.println(ans);
		}
	}
	
	static int check(int i) {
		
		int min = Integer.MAX_VALUE;
		
		for(int j=0; j<n; j++) {
			
			if(j==i || d[j]==d[i]) continue;
			
			int dx = Math.abs(x[i]-x[j]);
			int dy = Math.abs(y[i]-y[j]);
			
			if(d[i]=='N') {
				if(x[i]<x[j] || y[i]>y[j]) continue;
				if(dx < dy && check(j)>=dx) min = Math.min(min, dy);
			}
			else {
				if(x[i]>x[j] || y[i]<y[j]) continue;
				if(dx > dy && check(j) >= dy) min = Math.min(min, dx);
			}
		}
		
		return min;
	}
	
}
