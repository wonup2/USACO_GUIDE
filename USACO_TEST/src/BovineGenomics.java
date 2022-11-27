import java.util.*;
import java.io.*;

public class BovineGenomics {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, m, ans;
	static HashSet<Character> [] s, p;

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
				
		s = new HashSet[m];
		for(int i=0; i<m; i++) 
			s[i] = new HashSet<Character>();
		
		p = new HashSet[m];
		for(int i=0; i<m; i++) 
			p[i] = new HashSet<Character>();
			
		for(int i=0; i<n; i++) {
			String temp = in.readLine();
			for(int j=0; j<m; j++)
				s[j].add(temp.charAt(j));
		}	
		
		for(int i=0; i<n; i++) {
			String temp = in.readLine();
			for(int j=0; j<m; j++)
				p[j].add(temp.charAt(j));
		}
		
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString(p));

	}
	
	static void solve() {
		
		
		
	}

}