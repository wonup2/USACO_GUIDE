import java.util.*;


public class U20BDec_ABC {
	static Scanner in;
	static int a[];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();

	}

	static void init() {
		a = new int[7];
		for(int i=0; i<7; i++) a[i] = in.nextInt();
		
	}
	
	static void solve() {
		
		Arrays.sort(a);
		
		System.out.printf("%d %d %d\n", a[0], a[1], a[6]-a[0]-a[1]);
	}
}
