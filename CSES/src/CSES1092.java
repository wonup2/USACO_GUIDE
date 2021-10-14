import java.util.*;

public class CSES1092 {

	static Scanner in;
	static long n, sum;
	static HashSet<Integer> a, b;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		
	}	
	
	static void init() {
		n = in.nextLong();
		sum = n*(n+1)/2;
		
		if(sum%2!=0) System.out.println("NO");
		else {
			System.out.println("YES");
			solve();
		}
	}
	
	static void solve() {
		a = new HashSet<Integer>();
		b = new HashSet<Integer>();
		
		for(int i=1; i<=n; i++) a.add(i);
		
		sum /=2;
		
		while(sum>0) {
			
			if(sum<n) {
				b.add((int)sum);
				a.remove((int)sum);
				break;
			}
			else {
				b.add((int)n);
				a.remove((int)n);
				sum-=n;
				n--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(a.size()).append("\n");
		for(int s:a) sb.append(s).append(" ");
		
		sb.append("\n").append(b.size()).append("\n");
		for(int s:b) sb.append(s).append(" ");
		
		System.out.println(sb.toString());

	}
}