import java.util.*;
import java.io.*;

public class CF279_B_Books {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, t;
	static long sum, a[];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		a = new long[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
	}
	
	static void solve() {
		int i=0, j=0, cnt = 0;
		
		while(i<n && j<n) {
			
			sum+=a[i];
			cnt++;
			i++;

			if(sum > t) {
				sum-=a[j];
				cnt--;
				j++;
			}
		}
		
		if(cnt<0) cnt = 0;
		System.out.println(cnt);
	}
}
