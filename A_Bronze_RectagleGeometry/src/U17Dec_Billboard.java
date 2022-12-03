import java.util.*;

public class U17Dec_Billboard {

	static Scanner in;
	static boolean a[][];
	static int x1, y1, x2, y2, cnt;
	
	
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();		
		
	}

	static void init() {
		a = new boolean[2001][2001];
		
		b();
		b();
		t();
		
		System.out.println(cnt);
	}
	
	static void b() {
		
		x1 = in.nextInt() + 1000;
		y1 = in.nextInt() + 1000;
		x2 = in.nextInt() + 1000;
		y2 = in.nextInt() + 1000;
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				if(!a[i][j]) cnt++;
				a[i][j] = true;
				
			}
		}
	}
	static void t() {
		
		x1 = in.nextInt() + 1000;
		y1 = in.nextInt() + 1000;
		x2 = in.nextInt() + 1000;
		y2 = in.nextInt() + 1000;
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				if(a[i][j]) cnt--;
			}
		}
	}
	
	
}
