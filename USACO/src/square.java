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
		
		x[0]= in.nextInt();
		y[0]= in.nextInt();
		x[1]= in.nextInt();
		y[1]= in.nextInt();
		x[2]= in.nextInt();
		y[2]= in.nextInt();
		x[3]= in.nextInt();
		y[3]= in.nextInt();
	}

	static void solve() {
		
		Arrays.sort(x);
		Arrays.sort(y);

		int lenX = x[3]-x[0];
		int lenY = y[3]-y[0];
		
		int ans = Math.max(lenX, lenY);
		
		out.println(ans * ans);
		
	}
}
