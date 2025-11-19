//White Sheet
import java.util.*;

public class CF1216 {

	static Scanner in;
	static point a, b, c;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		a = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		c = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	}
	static void solve() {
		long overlap = ol(a, b) + ol(a, c) - ol(a, b, c);
		long area = (a.x1-a.x2) * (a.y1-a.y2);		
		System.out.println(area + " " + overlap);
		System.out.println(ol(a,b));
		System.out.println(ol(a,c));
		System.out.println(ol(a,b,c));

		if(overlap < area) System.out.println("YES");
		else System.out.println("NO");
	}

	static long ol(point a, point b) {
		long left = Math.max(a.x1, b.x1);
		long right = Math.min(a.x2, b.x2);
		long bottom = Math.max(a.y1, b.y1);
		long top = Math.min(a.y2, b.y2);
		
		if(left > right || bottom > top) return 0;
		return (right - left) * (top - bottom);
	}
	
	static long ol(point a, point b, point c) {
		long left = Math.max(a.x1, Math.max(b.x1, c.x1));
		long right = Math.min(a.x2, Math.min(b.x2, c.x2));
		long bottom = Math.max(a.y1, Math.max(b.y1, c.y1));
		long top = Math.min(a.y2, Math.min(b.y2, c.y2));
		
		if(left > right || bottom > top) return 0;
		return (right - left) * (top - bottom);
	} 

	static class point{
		long x1, y1, x2, y2;
		point(long a, long b, long c, long d){
			x1 = a; y1 = b; 
			x2 = c; y2 = d; 
		}
	}
}
