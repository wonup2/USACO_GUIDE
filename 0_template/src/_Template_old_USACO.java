import java.util.*;
import java.io.*;

public class _Template_old_USACO {

	static BufferedReader in;
	static StringTokenizer st;	
	
	static PrintWriter out;

	static String f = "test";
	static int n;

	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new FileReader(f+".in"));
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		
		
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
	}
	
	static void solve() {
		
	}

}