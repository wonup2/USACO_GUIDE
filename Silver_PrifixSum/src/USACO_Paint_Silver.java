import java.util.*;
import java.io.*;

public class USACO_Paint_Silver {

	//static Scanner in;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int max = 1000;
	static int n, k, a[][], x1, y1, x2, y2, ans;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("paintbarn.in"));
		out = new PrintWriter(new File("paintbarn.out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {	
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());	
		a = new int[max+1][max+1];
		ans = 0;
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<n; i++) mark();
		
		painting();
		
		out.println(ans);
			
	}
	
	static void mark() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		for(int i=x1; i<x2; i++) {
			a[y1][i]++;
			a[y2][i]--;
		}
	}
	
	static void painting() {
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<max; j++) {
				if(a[i][j]==k) ans++;
				a[i+1][j] += a[i][j];
			}
		}
	}

}

/*
3 2
1 1 5 5
4 4 7 6
3 3 8 7
*/