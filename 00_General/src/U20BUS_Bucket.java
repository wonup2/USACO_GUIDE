import java.util.Scanner;

public class U20BUS_Bucket {
	static Scanner in;
	static int bx, by, rx, ry, lx, ly;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();

	}
	
	static void init() {

		for(int i=0; i<10; i++) {
			String s = in.nextLine();
			if(s.contains("B")) {
				bx = s.indexOf("B");
				by = i;
			}
			if(s.contains("R")) {
				rx = s.indexOf("R");
				ry = i;
			}
			if(s.contains("L")) {
				lx = s.indexOf("L");
				ly = i;
			}		
		}
	}
	
	static void solve() {
		
		int ans = Math.abs(bx-lx) + Math.abs(by-ly) - 1;
		System.out.println(ans);
		if(check())ans += 2;
		
		System.out.println(ans);
		
	}
	
	static boolean check() {
		
		if(by==ry && ry==ly && (bx <rx && rx < lx || bx >rx && rx > lx)) return true;
		if(bx==rx && rx==lx && (by <ry && ry < ly || by >ry && ry > ly)) return true;
		return false;
	}
}
