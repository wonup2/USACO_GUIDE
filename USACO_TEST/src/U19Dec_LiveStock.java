import java.util.*;
import java.io.*;

public class U19Dec_LiveStock {

	static Scanner in;
	static PrintWriter out;
	static String file = "test";
	
	static int n;
	static HashMap<Integer, String> m1;
	static HashMap<String, Integer> m2;
	static ArrayList<String> a, p;
	static String cow[] = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy","Sue"};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		Arrays.sort(cow);
		
		m1 = new HashMap<Integer, String>();
		m2 = new HashMap<String, Integer>();
		for(int i=0; i<8; i++) {
			m1.put(i, cow[i]);
			m2.put(cow[i], i);
		}
		
//		System.out.println(m1);
//		System.out.println(m2);		
		
		n = in.nextInt();
		a = new ArrayList<String>();
		for(int i=0; i<n; i++) {
			String t = m2.get(in.next())+"";
			in.next(); in.next(); in.next(); in.next();
			t += m2.get(in.next());
			
			a.add(t);
			a.add(t.charAt(1)+""+t.charAt(0));
		}
		
//		System.out.println(a);
		
		p = new ArrayList<String>();
		permutation("01234567", "");
		
//		System.out.println(p);
	}
	
	static void solve() {
		
		String ans = "";
		for(String s:p) {
			
			boolean flag = true;
			for(int i=0; i<a.size(); i+=2) {
				
				if(!(s.contains(a.get(i)) || s.contains(a.get(i+1)))) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				ans = s;
				break;
			}
		}
		
		//System.out.println(ans);
		
		for(int i=0; i<ans.length(); i++)
			out.println(m1.get(ans.charAt(i)-'0'));
		
	}
	
	static void permutation(String left, String right) {
		
		if(left.length()==0) p.add(right);
		
		for(int i=0; i<left.length(); i++) {
			
			permutation(left.substring(0, i)+left.substring(i+1), right+left.charAt(i));
			
		}
	}
}
