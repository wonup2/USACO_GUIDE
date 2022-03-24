package USACO;

import java.util.*;
import java.io.*;

public class D_AngryCow {
	static int n, k, a[];
	
	static boolean f(int mid) {
		int start = a[0];
		int cow = 1;
		
		for(int i = 0; i < n; i++) {
			if(a[i]-start > mid*2) {
				cow++;
				start = a[i];
			}			
		}
		return(cow<=k);
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new FileReader("angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(a);

		int low = 0;
		int high = 500000000;
		int mid = 0;
		int ans = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(f(mid)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		
		out.println(ans);
		
		in.close();
		out.close();
	}	
}
