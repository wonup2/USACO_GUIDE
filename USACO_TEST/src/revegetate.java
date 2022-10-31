import java.util.*;
import java.io.*;

public class revegetate {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, m;
	static TreeSet<Integer> [] farm, connected;
	

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {

		n = in.nextInt();
		m = in.nextInt();
		
		farm = new TreeSet[n];
		connected = new TreeSet[n];
		
		for(int i=0; i<n; i++) {
			farm[i] = new TreeSet<Integer>();
			farm[i].add(1);
			farm[i].add(2);
			farm[i].add(3);
			farm[i].add(4);

			connected[i] = new TreeSet<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			
			if(x<y) connected[x].add(y);
			else connected[y].add(x);
		}
		
		System.out.println(Arrays.toString(farm));
		System.out.println(Arrays.toString(connected));

	}
	
	static void solve() {
		
		String ans = "";
		
		for(int i=0; i<n; i++) {
			int seed = farm[i].first();
			ans += seed;
			
			for(int f:connected[i]) {
				farm[f].remove(seed);
			}			
		}
		
		System.out.println(ans);
	}

}