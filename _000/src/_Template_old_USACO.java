import java.util.*;
import java.io.*;

public class _Template_old_USACO {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static String s, t;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		s = in.readLine();
		t = in.readLine();
	}
	
	static void solve() {
		
	}

}