import java.util.*;
import java.io.*;

public class CSES1755 {
	static BufferedReader in;
	static int a[];
	static String s;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		s = in.readLine();
		a = new int[26];
		int len = s.length();
		for(int i=0; i<len; i++) a[s.charAt(i)-'A']++;
		
		int odd = 0;
		String mid = "";
		for(int i=0; i<26; i++) {
			if(a[i]%2==1) {
				odd++;
				mid = (char)(i+'A')+"";
			}
		}
		
		if(odd>1) System.out.println("NO SOLUTION");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<26; i++) {
				if(a[i]==0) continue;
				char c = (char)(i+'A');
				for(int j=0; j<a[i]/2; j++) sb.append(c);
			}
			
			String r = sb.reverse().toString();
			sb.reverse();
			sb.append(mid).append(r);
			System.out.println(sb.toString());
		}
	}
}
