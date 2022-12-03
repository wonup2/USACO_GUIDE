import java.util.*;
import java.io.*;

public class U17US_BovineGenomics_Bronze {

	static BufferedReader in;
	static PrintWriter out;
	static int n, m;
	static HashSet<Character> s, p;
	static char g[][];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("test.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken())*2;
		m = Integer.parseInt(st.nextToken());		
		
		g = new char[n][];
		
		for(int i=0; i<n; i++) 
			g[i] = in.readLine().toCharArray();		
		
	}
	static void solve() {
		
		int ans = 0;
		
		for(int j=0; j<m; j++)
			if(check(j)) ans++;
		
		out.println(ans);
	}
	static boolean check(int j) {
		
		s = new HashSet<Character>();
		p = new HashSet<Character>();
		
		for(int i=0; i<n/2; i++) s.add(g[i][j]);
		for(int i=n/2; i<n; i++) p.add(g[i][j]);
		
		for(char c:s)
			if(p.contains(c)) return false;

		return true;
	}
}