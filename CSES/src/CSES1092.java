import java.util.*;

public class CSES1092 {

	static Scanner in;
	static long n, sum;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		n = in.nextLong();
		
		//first
		sum = n*(n+1)/2;
		
		if(sum % 2 != 0) System.out.println("NO");
		else {
			System.out.println("YES");
			sum /= 2;
			solve();
		}
		
	}

	static void solve() {
		
		//second
		HashSet<Integer> g1 = new HashSet<Integer>();
		HashSet<Integer> g2 = new HashSet<Integer>();

		int t = (int)n;
		
		for(int i=1; i<=t; i++) g1.add(i);
		
		while(sum > 0) {
			
			if(sum-t < 0) {
				g1.remove((int)sum);
				g2.add((int)sum);
				break;
			}
			else {
				sum-=t;
				g1.remove(t);
				g2.add(t);
				t--;
			}			
		}
		
		//output
		StringBuilder sb = new StringBuilder();
		
		sb.append(g1.size()).append("\n");
		for(int s: g1) sb.append(s).append(" ");		
		
		sb.append("\n").append(g2.size()).append("\n");
		for(int s: g2) sb.append(s).append(" ");
				
		System.out.println(sb.toString());
	}	
}