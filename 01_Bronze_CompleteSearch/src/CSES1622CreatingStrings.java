import java.util.*;

public class CSES1622CreatingStrings {
	static Scanner in;
	static String s;
	static TreeSet<String> p;
	
	public static void main(String[] a) {	
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		s = in.next();
		p = new TreeSet<String>();	
	}
	
	static void solve() {
		
		permutation(s, "");
		StringBuilder sb = new StringBuilder();
		for(String s:p)
			sb.append(s).append("\n");
		System.out.println(p.size());
		System.out.print(sb.toString());
		
	}
	static void permutation(String left, String right) {
	    if(left.length() == 0) {
	    	p.add(right); 
	    	return;
	    }
	    for(int i = 0; i < left.length(); i++) {
	    	char c = left.charAt(i);
	    	String l = left.substring(0, i) + left.substring(i + 1);
	    	String r = right + c;
	    	permutation(l, r); 
	    }
	}
}