import java.io.*;
import java.util.*;

public class U18BFeb_Teleportation {

	static Scanner in;
	static PrintWriter out;
	static int a, b, x, y;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("teleport.in"));
		out = new PrintWriter(new File("teleport.out"));
		
		init();
		solve();
		
		in.close();
		out.close();

	}

	static void init() {
		
		a = in.nextInt();
		b = in.nextInt();
		x = in.nextInt();
		y = in.nextInt();
	}
	
	static void solve() {
		
		int ans = Math.abs(a-b);
		ans = Math.min(ans, Math.abs(a-x)+Math.abs(y-b));
		ans = Math.min(ans, Math.abs(a-y)+Math.abs(x-b));
		
		out.println(ans);

	}
}
