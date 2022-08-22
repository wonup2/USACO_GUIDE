import java.util.*;

public class U16BJan_Promotion{
	
	static Scanner in;
	static int a[];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		
	}

	static void init() {
		a = new int[8];
		for(int i=0; i<8; i++) a[i] = in.nextInt();
		
	}
	
	static void solve() {
		
		int gp = a[7] - a[6];
		int sg = a[5] - a[4] + gp;
		int bs = a[3] - a[2] + a[5] - a[4] + gp;
		
		System.out.printf("%d\n%d\n%d\n", bs, sg, gp);
	}
}
