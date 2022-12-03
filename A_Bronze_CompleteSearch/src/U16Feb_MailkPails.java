import java.io.*;
import java.util.*;

public class U16Feb_MailkPails {
	static Scanner in;
	static PrintWriter out;
	static int x, y, m, ans;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new FileReader("test.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {

		x = in.nextInt();
		y = in.nextInt();
		m = in.nextInt();		
	}
	
	static void solve() {
		ans = 0;
		
		for(int i = 0; i*x <= m; i++) {

			for(int j = 0; i*x + j*y <= m; j++) {
				
				ans = Math.max(ans, i*x + j*y);
				
			}
		}
		
		out.println(ans);
	}
}