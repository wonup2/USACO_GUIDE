import java.util.*;
import java.io.*;

public class billboard2 {

	static Scanner in;
	static PrintWriter out;
	static String filename = "billboard";
	static int ans, x1, y1, x2, y2, minX, maxX, minY, maxY;
	static boolean a[][];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(filename+".in"));		
		out = new PrintWriter(new File(filename+".out")); 
		init();
		solve();		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {	
		
		a = new boolean[2001][2001];
		minX = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
		maxY = Integer.MIN_VALUE;
	}
	
	static void solve() throws IOException {
		//billboard 1
		x1 = in.nextInt()+1000;
		y1 = in.nextInt()+1000;
		x2 = in.nextInt()+1000;
		y2 = in.nextInt()+1000;
		
		for(int i=x1; i<x2; i++) {
			for(int j = y1; j<y2; j++) {
				a[i][j] = true;
			}
		}
		
		//billboard 2
		x1 = in.nextInt()+1000;
		y1 = in.nextInt()+1000;
		x2 = in.nextInt()+1000;
		y2 = in.nextInt()+1000;
		
		for(int i=x1; i<x2; i++) {
			for(int j = y1; j<y2; j++) {
				a[i][j] = false;
			}
		}
		
		//check showing part of billboard 1
		boolean flag = false;
		for(int i=0; i<2001; i++) {
			for(int j = 0; j<2001; j++) {
				if(a[i][j]) {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX, i);
					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
					flag = true;
				}
			}
		}
		
		ans = (maxX-minX+1) * (maxY-minY+1);
		if(!flag) ans = 0;
		out.println(ans);
	}

}
