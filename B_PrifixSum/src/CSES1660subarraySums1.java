import java.util.*;
import java.io.*;

public class CSES1660subarraySums1 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, x, a[], ans;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));		
		init();
		solve();		
		in.close();
	}
	
	static void init() throws IOException {	
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(in.readLine());

		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		//System.out.println(Arrays.toString(a));
		ans = 0;
	}
	
	static void solve() throws IOException {
		int i=0, j=0;
		int sum = a[0];
		while(true) {
			if(sum<x) {
				i++; if(i==n) break;
				sum+=a[i];
			}
			else{
				if(sum==x) ans++;
				sum-=a[j];
				j++; if(j==n) break;				
			}
		}
		System.out.println(ans);
	}

}
