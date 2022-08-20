import java.util.*;
import java.io.*;

public class U17US_BovineGenomics_Silver {

	static BufferedReader in;
	static PrintWriter out;
	static int n, m;
	static char s[][], p[][];
	static boolean hasGene[][];
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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = new char[n][];
		p = new char[n][];
		
		for(int i=0; i<n; i++) s[i]=in.readLine().toCharArray();
		for(int i=0; i<n; i++) p[i]=in.readLine().toCharArray();
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int j=0; j<m; j++)
			if(check(j)) ans++;
		
		out.println(ans);
		
	}
	
	static boolean check(int j) {
		return true;
	}
}