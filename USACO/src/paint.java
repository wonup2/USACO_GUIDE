import java.util.*;
import java.io.*;

public class paint {

	static Scanner in;
	static PrintWriter out;
	static int s1, e1, s2, e2;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("paint.in"));
		out = new PrintWriter(new File("paint.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		s1 = in.nextInt();
		e1 = in.nextInt();
		s2 = in.nextInt();
		e2 = in.nextInt();
	}

	static void solve() {
		
		int sum = e1-s1 + e2-s2;

		int a = Math.max(s1, s2);
		int b = Math.min(e1, e2);
		
		int ans = sum - Math.max(0, b-a);
		
		out.println(ans);

	}
}
