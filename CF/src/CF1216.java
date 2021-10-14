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
//		System.out.println(ol(a, b));
//		System.out.println(ol(a, c));
//		System.out.println(ol(a, b, c));

		long area = Math.abs(a.x1-a.x2) * Math.abs(a.y1-a.y2);
		
		if(overlap < area) System.out.println("YES");
		else System.out.println("NO");
	}

	static long ol(point a, point b) {
		long maxX = Math.max(a.x1, b.x1);
		long minX = Math.min(a.x2, b.x2);
		long maxY = Math.max(a.y1, b.y1);
		long minY = Math.min(a.y2, b.y2);
		if(maxX>minX||maxY>minY) return 0;
		return (minX-maxX)*(minY-maxY);
	}
	
	static long ol(point a, point b, point c) {
		long maxX = Math.max(a.x1, Math.max(b.x1, c.x1));
		long minX = Math.min(a.x2, Math.min(b.x2, c.x2));
		long maxY = Math.max(a.y1, Math.max(b.y1, c.y1));
		long minY = Math.min(a.y2, Math.min(b.y2, c.y2));
		
		if(maxX>minX||maxY>minY) return 0;
		return (minX-maxX)*(minY-maxY);
	} 

	static class point{
		int x1, y1, x2, y2;
		point(int a, int b, int c, int d){
			x1 = a; y1 = b; 
			x2 = c; y2 = d; 
		}
	}
}
