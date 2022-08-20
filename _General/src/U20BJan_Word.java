import java.util.*;
import java.io.*;

public class U20BJan_Word {

	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static String s[];
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("word.in"));
		out = new PrintWriter(new File("word.out"));
				
		init();		
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		s = in.nextLine().split(" ");
	}

	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		int len = s[0].length();
		sb.append(s[0]);
		
		for (int i=1; i<s.length; i++) {
				
			if(len+s[i].length()>m) {
				sb.append("\n").append(s[i]);
				len = s[i].length();
			}
			else {
				sb.append(" ").append(s[i]);	
				len += s[i].length();
			}
		}
		
		out.println(sb.toString());
	}
}
