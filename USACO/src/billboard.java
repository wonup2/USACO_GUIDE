import java.util.*;
import java.io.*;

public class billboard {

	static Scanner in;
	static PrintWriter out;
	static int ans;
	static pos b1, b2, t;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b1 = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b2 = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		t = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	}
	
	static void solve() {
		ans = area(b1) + area(b2) - overlap(b1, t) - overlap(b2, t);
		out.println(ans);
	}
	
	static int area(pos n) {
		return (n.x2-n.x1) * (n.y2-n.y1);
	}
	
	static int overlap(pos b, pos t) {
		int x = Math.max(Math.min(b.x2,  t.x2)-Math.max(b.x1,  t.x1), 0);
		int y = Math.max(Math.min(b.y2,  t.y2)-Math.max(b.y1,  t.y1), 0);
		
		return x*y;
	}	
	
	static class pos{
		int x1, y1, x2, y2;
		pos(int a, int b, int c, int d){
			x1=a; y1=b; x2=c; y2=d;
		}
		
		public String toString() {
			return x1+" "+y1+" "+x2+" "+y2;
		}
	}

}
