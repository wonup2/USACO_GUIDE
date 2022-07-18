import java.util.*;
import java.io.*;

public class U18Dec_BovineShuffle {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st1, st2;	
	static String f = "test";
	static int n, a[], b[], c[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		b = new int[n];
		c = new int[n];

		st1 = new StringTokenizer(in.readLine());
		st2 = new StringTokenizer(in.readLine());

		for(int i=0; i<n; i++) {
			a[Integer.parseInt(st1.nextToken())-1] = i;
			b[i] = Integer.parseInt(st2.nextToken());
		}
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			c[a[a[a[i]]]] = b[i];
		}
		
		System.out.println(Arrays.toString(c));
	}
}