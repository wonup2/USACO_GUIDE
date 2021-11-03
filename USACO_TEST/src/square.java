import java.util.*;
import java.io.*;

public class square {

	static Scanner in;
	static PrintWriter out;
	static int x[], y[];
	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		x = new int[4];
		y = new int[4];
		
		for(int i=0; i<4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}	
	}

	static void solve() {
		
		Arrays.sort(x);
		Arrays.sort(y);			

		int diffX = x[3]-x[0];
		int diffY = y[3]-y[0];
		
		int max = Math.max(diffX, diffY);
		
		int ans = max * max;
		
		out.println(ans);

		
	}
}
