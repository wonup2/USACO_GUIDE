import java.util.*;
import java.io.*;

public class square {

	static Scanner in;
	static PrintWriter out;
	static int x1, y1, x2, y2, x3, y3, x4, y4;
	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		x3 = in.nextInt();
		y3 = in.nextInt();
		x4 = in.nextInt();
		y4 = in.nextInt();
	}

	static void solve() {
		
		int leftX = Math.min( Math.min(x1,  x2), Math.min(x3,  x4));
		int rightX = Math.max( Math.max(x1,  x2), Math.max(x3,  x4));
		
		int bottomY = Math.min( Math.min(y1,  y2), Math.min(y3,  y4));
		int topY = Math.max( Math.max(y1,  y2), Math.max(y3,  y4));
		
		
		System.out.println(leftX +" "+rightX+" "+bottomY+" "+topY);
		


		
	}
}
