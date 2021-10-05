import java.util.*;

public class CSES1092 {

	static Scanner in;
	static long n, sum;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		n = in.nextLong();
		sum = n*(n+1);
		
		if(sum%4!=0) System.out.println("NO");
		else {
			System.out.println("YES");
			sum=sum/4;
			find();
		}
	}

	static void find() {
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		int t = (int)n;
		for(int i=1; i<t; i++) s1.add(i);
 
		while(sum!=0) {
			if(sum-t<0) {				
				s1.remove((int)sum);
				s2.add((int)sum);
				break;
			}
			else {
				sum-=t;
				s1.remove(t);
				s2.add(t);
				t--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(s1.size());
		for(int s:s1) {
			sb.append(s).append(" ");
		}
		
		System.out.println(sb.toString()+"\n"+s2.size());
		sb = new StringBuilder();
		for(int s:s2) {
			sb.append(s).append(" ");
		}
		System.out.println(sb.toString());
	}
}