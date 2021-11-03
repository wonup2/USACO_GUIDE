import java.util.*;

public class CF1216 {

	static Scanner in;
	static pos a, b, c;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
		

	}

	
	static void init() {
		
		a = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		c = new pos(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

	}
	
	static void solve() {
		long area = (long)(a.x2-a.x1) * (long)(a.y2-a.y1);
		long overlap = ol(a, b) + ol(a, c) - ol(a, b, c);
		
		//System.out.println(area+" "+overlap);		
				
		if(area > overlap) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static long ol(pos a, pos b) {
		long left = Math.max(a.x1, b.x1);
		long right = Math.min(a.x2, b.x2);
		long bottom = Math.max(a.y1, b.y1);
		long top = Math.min(a.y2, b.y2);
		
		if(left > right || bottom > top) return 0;
		
		return (right-left)*(top-bottom);
	}
	
	static long ol(pos a, pos b, pos c) {
		long left = Math.max(c.x1, Math.max(a.x1, b.x1));
		long right = Math.min(c.x2, Math.min(a.x2, b.x2));
		long bottom = Math.max(c.y1, Math.max(a.y1, b.y1));
		long top = Math.min(c.y2, Math.min(a.y2, b.y2));
		
		if(left > right || bottom > top) return 0;
		
		return (right-left)*(top-bottom);
	}
	
	static class pos{
		int x1, y1, x2, y2;
		pos(int a, int b, int c, int d){
			x1=a; y1=b; x2=c; y2=d;
		}
	}
}
