import java.util.*;
import java.io.*;

public class speeding {

	static Scanner in;
	static PrintWriter out;
	static String filename = "speeding";
	static int n, m, road[], bessie[], ans;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(filename+".in"));		
		out = new PrintWriter(new File(filename+".out")); 
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {	

		n = in.nextInt();
		m = in.nextInt();
		road = new int[101];
		bessie = new int[101];
	}
	
	static void solve() throws IOException {
		
		int start = 0;
		int end = 0;
		int mph = 0;
		
		//road
		for(int i=0; i<n; i++) {
			end = in.nextInt();
			
		}
		
		//bessie
		
		
		//max over speed
		
		
		out.println(ans);
	}

}
