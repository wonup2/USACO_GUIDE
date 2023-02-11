

import java.util.*;

public class d_birthdayParty {

	static Scanner in;
	static int n, m;
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		while(true) {
			n = in.nextInt();
			m = in.nextInt();
		
			if(n==0 && m==0) break;
			
			solve();
		}
	}
	
	static void solve() {
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		boolean ok = true;
		for(int i=0; i<n; i++) {
			if(a[i].size()<=1) ok = false;
		}
		
		if(ok) System.out.println("No");
		else System.out.println("Yes");
	}

}
