import java.util.*;
import java.io.*;

public class CSES1660 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, ans;
	static long a[], sum, x;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Long.parseLong(st.nextToken());
		
		a = new long[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
	}
	
	static void solve() throws IOException {
		
		int i=0;
		int j=0;
		sum = a[0];
		
		while(true) {
			
			if(sum<x) {
				i++; if(i==n) break;
				sum+=a[i];
			}
			else {
				if(sum==x) ans++;
				sum-=a[j];
				j++; if(j==n) break;
			}
		}
		
		System.out.println(ans);
	}

}
