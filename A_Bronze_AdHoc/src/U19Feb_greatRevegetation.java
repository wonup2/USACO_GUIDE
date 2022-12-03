import java.util.*;
import java.io.*;

public class U19Feb_greatRevegetation {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "revegetate";
	static int n, m;
	static TreeSet<Integer>[] farm;
	static HashSet<Integer>[] connected;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		farm = new TreeSet[n];
		connected = new HashSet[n];
		
		for(int i=0; i<n; i++) {
			farm[i] = new TreeSet<Integer>();
			farm[i].add(1);
			farm[i].add(2);
			farm[i].add(3);
			farm[i].add(4);
			connected[i] = new HashSet<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			if(x<y) connected[x].add(y);
			else connected[y].add(x);
		}
//		System.out.println(Arrays.toString(seedOnFarm));
//
//		System.out.println(Arrays.toString(connected));
	}
	
	static void solve() {
		
		String ans="";
		for(int i=0; i<n; i++) {
			Integer seed = farm[i].first();
			ans += seed;

			for(int c:connected[i]) farm[c].remove(seed);			
		}
		
		out.println(ans);
	}

}