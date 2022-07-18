import java.util.*;
import java.io.*;


public class U20BJan_Word {

	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static String s[];
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(System.in);

		in = new Scanner(new File("word.in"));
		out = new PrintWriter(new File("word.out"));
		
		
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		s = in.nextLine().split(" ");
		
		solve();
		in.close();
		out.close();
	}

	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		int len = s[0].length();
		sb.append(s[0]);
		
		for (int i=1; i<s.length; i++) {
			String word = s[i];			
			if(len+word.length()>m) {
				sb.append("\n").append(word);
				len = word.length();
			}
			else {
				sb.append(" ").append(word);	
				len += word.length();
			}
		}
		
		out.println(sb.toString());
	}
}
