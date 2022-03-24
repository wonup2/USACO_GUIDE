import java.util.*;
import java.io.*;

public class _Template_new_USACO {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;

	static int n;
	
	public static void main(String[] args) throws IOException {

		//in = new Scanner(System.in);		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws IOException {	
		st = new StringTokenizer(in.readLine());

	}
	
	static void solve() throws IOException {
	}
	
	
	class pair implements Comparable<pair>{
		
		int a, b;
		pair(int c, int d){
			a=c;
			b=d;
		}
		@Override
		public int compareTo(pair o) {
			
			return this.a-o.a;
		}

		public String toString() {
			return a+" "+b;
		}
	}
}
