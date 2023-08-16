import java.io.*;
import java.util.*;

public class B2188_BarnAssignment {

	static List<Integer>[] a;
	static boolean[] v;
	static int n, m, s, b[];
	static Scanner in;
	
	public static void main(String[] args) throws  IOException{
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		a = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) 
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			s = in.nextInt();
			for(int j=1; j<=s; j++) a[i].add(in.nextInt());
		}
		
		v = new boolean[m+1];
		b = new int[m+1];
	}
	
	static void solve() {
		
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static boolean dfs(int cow) {
		
		for(int i : a[cow]) {
			
			if(v[i]) continue;
			v[i]=true;
			if(b[i]==0 || dfs(b[i])) {
				b[i] = cow;
				return true;
			}
		}
		
		return false;
	}
}