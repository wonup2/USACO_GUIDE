import java.util.*;
import java.io.*;
public class U19DEC_whereami {
	static Scanner in;
	static PrintWriter out;
	static String file = "test";
	static int n;
	static HashSet<String> a;
	static String s;
	
	static void init() {
		n = in.nextInt();
		s = in.next();
	}

	static void solve() {
	
		for(int i=1; i<n; i++) {
			a = new HashSet<String>();
			for(int j=0; j<=n-i; j++) a.add(s.substring(j, j+i));
		
			if(a.size()==n-i+1) {
				out.println(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));		
		init();
		solve();	
		in.close();
		out.close();
	}
}