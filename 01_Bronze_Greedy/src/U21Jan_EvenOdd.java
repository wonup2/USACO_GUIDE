import java.util.*;
import java.io.*;

public class U21Jan_EvenOdd {

	static Scanner in;
	//static BufferedReader in;
	//static StringTokenizer st;

	static int n, even, odd;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);		
		//in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
		in.close();
	}
	
	static void init(){	

		n = in.nextInt();
		
		for(int i=0; i<n; i++) {
			if(in.nextInt()%2==0) even++;
			else odd++;
		}

	}
	
	static void solve() throws IOException {
		
		int ans = 0;
		
		while(odd>even) {
			odd-=2;
			even++;
		}
		
		if(even==odd) ans = even + odd;
		else ans = odd * 2 + 1;

		System.out.println(ans);

	}
	
	
	class pair implements Comparable<pair>{
		
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
