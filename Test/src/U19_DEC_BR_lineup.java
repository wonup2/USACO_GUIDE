import java.util.*;
import java.io.*;

public class U19_DEC_BR_lineup {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static HashMap<String, Integer> m1;
	static ArrayList<String> p, c;
	static String name[] = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};

	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("test.in"));
		out = new PrintWriter(new File("test.out"));
		
		init();
		solve();
		in.close();
		out.close();
		
	}
	
	static void init() {
		naming();
		p = new ArrayList<String>();
		permutation("", 8);		
		
		c = new ArrayList<String>();
		
		n = in.nextInt();
		for(int i=0; i<n; i++) {
			String f = in.next();
			in.next();in.next();in.next();in.next();
			String s = in.next();
			c.add(m1.get(f)+""+m1.get(s));
			c.add(m1.get(s)+""+m1.get(f));
		}		
	}
	
	static void solve() {
		
		String ans = "";
		
		for(String s:p) {  
			
			boolean flag = true;
			for(int i=0; i<c.size(); i+=2) {
				String a = c.get(i);
				String b = c.get(i+1);
				if( !s.contains(a) && !s.contains(b)) flag=false;				
			}
			
			if(flag) {
				ans = s;
				break;
			}
		}		
		
		for(int i=0; i<8; i++)
			out.println(name[ans.charAt(i)-'0']);
	}
	
	static void naming() {
		Arrays.sort(name);		
		m1 = new HashMap<String, Integer>();
		for(int i=0; i<8; i++) m1.put(name[i], i);		
	}
	
	static void permutation(String s, int n) {		
		if(s.length()==8) p.add(s);		
		for(int a = 0; a<n; a++) 			
			if(!s.contains(a+"")) permutation(s+a, n);		
	}
}

