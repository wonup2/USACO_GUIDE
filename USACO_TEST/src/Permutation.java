import java.util.*;

public class Permutation {

	static Scanner in;
	static int n;
	static TreeSet<String> p1, p2;
	static String s="12345";
	public static void main(String[] args) {

		p1 = new TreeSet<String>();			
		p1(s);
		System.out.println(p1.size());
		for(String t:p1)System.out.println(t);
		
		
		p2 = new TreeSet<String>();
		p2(s, "");
		System.out.println(p2.size());
		for(String t:p2) System.out.println(t);
	}
	
	static void p2(String left, String right) {
		
		if(left.length()==0) p2.add(right);
		
		for(int i=0; i<left.length(); i++) {
			String r = right + left.charAt(i);
			String l = left.substring(0, i) + left.substring(i+1);
			p2(l, r);
		}
	}
		
	static void p1(String s) {
		
		for(int a=0; a<5; a++) {
			for(int b=0; b<5; b++) {
				if(a==b) continue;
				for(int c=0; c<5; c++) {
					if(a==c || b==c) continue;
					for(int d=0; d<5; d++) {
						if(a==d || b==d || c==d) continue;
						for(int e=0; e<5; e++) {
							if(e==a||e==b||e==c||e==d) continue;
							p1.add(""+s.charAt(a)+s.charAt(b)+s.charAt(c)+s.charAt(d)+s.charAt(e));

						}
					}
				}
			}
		}
	}	
}
