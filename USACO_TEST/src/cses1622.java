import java.util.*;

public class cses1622 {

	static Scanner in;
	static int n;
	static String s;
	static TreeSet<String> set;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		s = in.nextLine();
		set = new TreeSet<String>();
		p(s, "");
		
		for(String s:set)
			System.out.println(s);
		
	}
	
	static void p(String l, String r) {
		if(l.length()==0) set.add(r);
		
		for(int i=0; i<l.length(); i++) {
			String left = l.substring(0,i) + l.substring(i+1);
			String right = r + l.charAt(i);
			p(left, right);
		}


	}

}
