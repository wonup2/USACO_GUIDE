import java.io.*;
import java.util.*;

public class CSES1630 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static pair a[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());			
		
		a = new pair[n];
		
		while(--n>=0) {
			st = new StringTokenizer(in.readLine());
			a[n] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		
		long d=0l, f=0l;
		for(int i=0; i<a.length; i++) {
			d += a[i].a;
			f += a[i].b-d;
		}
		System.out.println(f);	

	}
	static class pair implements Comparable<pair>{
		
		int a, b;
		pair(int c, int d){
			a=c;
			b=d;
		}
		@Override
		public int compareTo(pair o) {
			
			return this.a-o.a;
		}

		public String toString() {
			return a+" "+b;
		}
	}
}
