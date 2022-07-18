import java.util.*;
import java.io.*;

public class U15BFeb_Censoring {

	static BufferedReader in;
	static PrintWriter out;
	static String f = "censor";
	static String s, t;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init()throws IOException {
		s = in.readLine();
		t = in.readLine();
	}
	
	static void solve() {
		StringBuilder sb = new StringBuilder();
		
		int len = t.length();
		for(int i=0; i<s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length()>=len && sb.substring(sb.length()-len).equals(t))
				sb.delete(sb.length()-len, sb.length()+1);
		}
		
		out.println(sb.toString());
	}
}
