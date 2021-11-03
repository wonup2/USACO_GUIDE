import java.util.*;
import java.io.*;

public class shell {

	static Scanner in;
	static PrintWriter out;
	static boolean a[];
	static int n, ans ;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("shell.in"));
		out = new PrintWriter(new File("shell.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		a = new boolean[3];
		ans = 0;
	}

	static void solve() {
		
		ans = Math.max(ans, set(0));
	}
	
	static int set(int n) {
		a = new boolean[3];
		a[n] = true;
		
		return 0;
	}
}
