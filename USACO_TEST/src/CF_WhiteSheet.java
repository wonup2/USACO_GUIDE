import java.util.*;

public class CF_WhiteSheet {

	static Scanner in;
	static point w, b1, b2;
	
	static class point{
		long x1, y1, x2, y2;
		point(long a, long b, long c, long d){
			x1 = a; y1 = b; x2 = c; y2 = d;
		}
		
		public String toString() {
			return x1 + " " + y1 + " " + x2 + " " + y2;
		}
	}
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		w = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		b1 = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		b2 = new point(in.nextLong(), in.nextLong(), in.nextLong(), in.nextLong());
		
//		System.out.println(w);
//		System.out.println(b1);
//		System.out.println(b2);

	}

	static void solve() {
		
		long wa = (w.x2-w.x1) * (w.y2-w.y1); // System.out.println(wa); //4
		
		long o1 = ol(w, b1);
		long o2 = ol(w, b2);
		long o3 = ol(w, b1, b2);
		
		long overLab = o1+o2-o3;
		
		if(overLab >= wa) System.out.println("NO");
		else System.out.println("YES");

	}
	
	static long ol(point w, point b) {
		
		long bx = Math.max(w.x1, b.x1); 
		long by = Math.max(w.y1, b.y1);
		long tx = Math.min(w.x2, b.x2);
		long ty = Math.min(w.y2, b.y2);
		
		//System.out.println(bx +" "+ by +" "+tx+" "+ty); 
		//2, 2, 3, 4
		//3, 2, 4, 4
		
		long width = tx-bx;
		long hight = ty-by;
		
		if(width < 0) return 0;
		else return width * hight;
	
	}
	
	
	static long ol(point w, point b1, point b2) {
		
		long bx = Math.max(Math.max(w.x1, b1.x1), b2.x1); 
		long by = Math.max(Math.max(w.y1, b1.y1), b2.y1);
		long tx = Math.min(Math.min(w.x2, b1.x2), b2.x2);
		long ty = Math.min(Math.min(w.y2, b1.y2), b2.y2);
		
		long width = tx-bx;
		long hight = ty-by;
		
		if(width < 0) return 0;
		else return width * hight;
	
	}
}
