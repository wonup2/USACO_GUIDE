import java.io.*;
import java.util.*;
public class U16Feb_LoadBalancing_Bronze {
	
	static Scanner in;
	static PrintWriter out;
	static int n, x[], y[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new FileReader("balancing.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {

		n = in.nextInt(); in.nextInt();

		x = new int[n];
		y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}		
	}
	
	static void solve() {
		
		int ans = n;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {

				int v = x[i]+1;
				int h = y[j]+1;
				int ur = 0, ul = 0, ll = 0, lr = 0;

				for(int k = 0; k < n; k++) {
					if(x[k] > v && y[k] > h) ur++;
					else if(x[k] < v && y[k] > h) ul++;					
					else if(x[k] < v && y[k] < h) ll++;				
					else if(x[k] > v && y[k] < h) lr++;					
				}
				
				int m[] = {ll, ul, lr, ur};
				Arrays.sort(m);				
				
				ans = Math.min(ans, m[3]);				
			}
		}
		
		out.println(ans);
	}
}