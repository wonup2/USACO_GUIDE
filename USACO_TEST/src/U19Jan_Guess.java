import java.util.*;

public class U19Jan_Guess {

	static Scanner in;
	static int n;
	static HashSet<String> [] a;  //<----------------------
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();

	}
	
	static void init() {
		n = in.nextInt();
		
		a = new HashSet[n];                //<----------------
		for(int i=0; i<n; i++)
			a[i] = new HashSet<String>();
		
		for(int i=0; i<n; i++) {
			in.next();
			int k = in.nextInt();
			for(int j=0; j<k; j++) {
				a[i].add(in.next());
			}
		}
			
		System.out.println(Arrays.toString(a));
		
	}

	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				
				int cnt=1;
				
				for(String s:a[i]) {					
					if(a[j].contains(s)) cnt++;
				}
				
				ans = Math.max(ans, cnt);
			}
		}
		
		System.out.println(ans);
	}
}

