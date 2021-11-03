import java.util.*;
import java.io.*;

public class b2 {

	static Scanner in;
	static PrintWriter out;
	static point b1, b2, t;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b1 = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b2 = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		t = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	}

	static void solve() {
		
		int total = area(b1) + area(b2);
		int overlap = ol(b1, t) + ol(b2, t);
		
		int ans = total - overlap;
		
		out.println(ans);
	}
	
	static int ol(point b, point t) {
		int left = Math.max(b.x1, t.x1);
		int right = Math.min(b.x2, t.x2);
		int bottom = Math.max(b.y1, t.y1);
		int top = Math.min(b.y2, t.y2);
		
		int area = (right - left) * (top - bottom);
		
		if(left > right || bottom > top) return 0;
		else return area;
	}
	
	static int area(point p) {
		return (p.x2 - p.x1) * (p.y2 - p.y1);
	}
	
	
	static class point{
		int x1, y1, x2, y2;
		point(int a, int b, int c, int d){
			x1 = a; y1 = b; x2 = c; y2 = d;
		}
	}
}
