import java.util.*;
import java.io.*;

public class art {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n;
	static char a[][];
	static HashSet<Character> set;
	static HashMap<Character, point> map;
	
	static class point{
		int x, y, X, Y;
		point(int a, int b, int c, int d){
			x=a;
			y=b;
			X=c;
			Y=d;
		}
		public String toString() {
			return x+""+y+""+X+""+Y;
		}
	}

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		n = in.nextInt();
		a = new char[n][];
		set = new HashSet<Character>();
		map = new HashMap<Character, point>();
		
		for(int i = 0; i<n; i++) {
			a[i] = in.next().toCharArray();
			for(int j = 0; j<n; j++) {
				char p = a[i][j];
				if(p=='0') continue;
				set.add(p);
				if(!map.containsKey(p)) map.put(p, new point(n, n, 0, 0));
				else {
					if(p=='0') continue;
					int x = Math.min(i, map.get(p).x);
					int y = Math.min(j, map.get(p).y);
					int X = Math.max(i, map.get(p).X);
					int Y = Math.max(j, map.get(p).Y);
					
					map.put(p, new point(x, y, X, Y));
				}
			}
		}		
	}
	
	static void solve() {		
		
		for(char p: map.keySet()) {
			int x = map.get(p).x;
			int y = map.get(p).y;
			int X = map.get(p).X;
			int Y = map.get(p).Y;
			
			for(int i=x; i<=X; i++) {
				for(int j=y; j<=Y; j++) {
					if(a[i][j]!=p) set.remove(a[i][j]);
				}
			}
		}		
		
		out.println(set.size());
	}

}