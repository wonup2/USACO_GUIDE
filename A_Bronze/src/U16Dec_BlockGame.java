import java.util.*;
import java.io.*;

public class U16Dec_BlockGame {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "blocks";
	static int n, a[], b[], c[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		
		c = new int[26];
		
		for(int i=0; i<n; i++) solve();
		
		for(int i=0; i<26; i++) out.println(c[i]);
	}
	
	static void solve() throws IOException {
		
		a = new int[26];
		b = new int[26];
		
		st = new StringTokenizer(in.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();

		for(int i=0; i<s1.length(); i++)
			a[s1.charAt(i)-'a']++;
		
		for(int i=0; i<s2.length(); i++)
			b[s2.charAt(i)-'a']++;
		
		for(int i=0; i<26; i++)
			c[i] += Math.max(a[i], b[i]);
	}
}