import java.util.*;
import java.io.*;

public class _Template_CF {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static String s;
	
	public static void main(String[] args) throws IOException {

		//in = new Scanner(new File("temp.in"));		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {	
	}
	
	static void solve() throws IOException {
		st = new StringTokenizer(in.readLine());
	}

}
