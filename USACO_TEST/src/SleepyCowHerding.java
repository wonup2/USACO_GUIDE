import java.util.*;
import java.io.*;

public class SleepyCowHerding {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int a[];

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		

		a = new int[]{in.nextInt(), in.nextInt(), in.nextInt()};
		
		Arrays.sort(a);
	}
	
	static void solve() {
		
		if(a[2]-a[0] == 2) out.println(0);
		else if (a[1]-a[0]==2 || a[2]-a[1]==2) out.println(1);
		else out.println(2);
		
		out.println(Math.max(a[2]-a[1], a[1]-a[0]) -1);
		
	}

}