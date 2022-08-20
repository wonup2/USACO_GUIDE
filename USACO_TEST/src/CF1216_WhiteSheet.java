import java.util.*;

public class CF1216_WhiteSheet {

	static Scanner in;
	static point w, b1, b2;
	
	
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		w = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		b1 = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		b2 = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		
	}
	
	static void solve() {
		
		long wa = (w.x2 - w.x1) * (w.y2 - w.y1);
		
		long o = ol(w, b1) + ol(w, b2) - ol(w, b1, b2);
		
		if(wa > o) System.out.println("YES");
		else System.out.println("NO");		
		
	}
	
	static long ol(point a, point b) {
		
		long lx = Math.max(a.x1, b.x1);
		long rx = Math.min(a.x2, b.x2);
		long by = Math.max(a.y1, b.y1);
		long ty = Math.min(a.y2, b.y2);
		
		if(lx>rx || by>ty) return 0;
		return (rx-lx) * (ty-by);	
	}
	
	static long ol(point a, point b, point c) {
		
		long lx = Math.max(  Math.max(a.x1, b.x1),  c.x1);
		long rx = Math.min(  Math.min(a.x2, b.x2),  c.x2);
		long by = Math.max(  Math.max(a.y1, b.y1),  c.y1);
		long ty = Math.min(  Math.min(a.y2, b.y2),  c.y2);
		
		if(lx>rx || by>ty) return 0;
		return (rx-lx) * (ty-by);	
	}
	
	
	
	static class point{
		long x1, y1, x2, y2;
		point(long a, long b, long c, long d){
			x1 = a;
			y1 = b; 
			x2 = c; 
			y2 = d;
		}
	}

}
