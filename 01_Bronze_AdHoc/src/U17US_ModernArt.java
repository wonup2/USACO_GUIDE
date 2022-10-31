import java.util.*;
import java.io.*;

public class U17US_ModernArt {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "art";
	static int n, a[][];
	static boolean check[];
	static point[] p;
	
	static class point{
		int x, y, X, Y;
		point(int a, int b, int c, int d){
			x = a;
			y = b; 
			X = c;
			Y = d;
		}
		
		public String toString() {
			return x +" "+y+" "+X+" "+Y;
		}
	}
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		p = new point[10];
		for(int i=0; i<10; i++)
			p[i] = new point(n, n, 0, 0);
		
		a = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = in.readLine();
			for(int j=0; j<n; j++) {
				a[i][j] = s.charAt(j)-'0';
				int num = a[i][j];
				p[num].x = Math.min(i, p[num].x);
				p[num].y = Math.min(j, p[num].y);
				p[num].X = Math.max(i, p[num].X);
				p[num].Y = Math.max(j, p[num].Y);
			}
		}
		
		check = new boolean[10];
	}
	
	static void solve() {
		
		for(int i = 1; i<10; i++) {
			int x = p[i].x;
			int y = p[i].y;
			int X = p[i].X;
			int Y = p[i].Y;
			if(x==n) {
				check[i] = true;
				continue;
			}
			for(int j=x; j<=X; j++) {
				for(int k=y; k<=Y; k++) {
					if(a[j][k] != i) {
						check[a[j][k]] = true;
					}
				}
			}

		}

		int cnt=0;
		for(int i=1; i<10; i++)
			if(!check[i]) cnt++;

		out.println(cnt);
	}

}