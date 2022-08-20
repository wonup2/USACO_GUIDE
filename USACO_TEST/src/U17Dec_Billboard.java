import java.util.*;
import java.io.*;

public class U17Dec_Billboard {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int x1, y1, x2, y2;
	static boolean a[][];

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		
		
		a = new boolean[2001][2001];
		
		for(int i=0; i<2; i++) {
			init();
			solve(true);
		}
		
		init();
		solve(false);
		
		
		int cnt = 0;
		for(int i=0; i<2001; i++) {
			for(int j=0; j<2001; j++) {
				if(a[i][j]) cnt++;
			}
		}
		
		out.println(cnt);
		
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		x1 = in.nextInt()+1000;
		y1 = in.nextInt()+1000;
		x2 = in.nextInt()+1000; 
		y2 = in.nextInt()+1000;
		
	}
	
	static void solve(boolean b) {
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				a[i][j] = b;
			}
		}
	}

}