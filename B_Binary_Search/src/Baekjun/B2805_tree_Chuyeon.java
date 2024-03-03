package Baekjun;

import java.io.*;
import java.util.*;

public class B2805_tree_Chuyeon{	
	
	static BufferedReader in;
	static StringTokenizer st;		
	static int n, m;
	static long a[],low, high, mid, ans;
	
	static boolean check(long mid) {
		
		long total=0l;
		for(int i=0; i<n; i++) {
		
			total += (a[i]-mid) < 0 ?     0 : a[i]-mid;
		}
		
		return total >= m;
	}	
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		in.close();
	}
	
	
	public static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken()); 
		m=Integer.parseInt(st.nextToken());  
		
		a=new long[n]; 
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(a);
		low=0; 
		high=a[n-1];
	}
	
	public static void solve() {
		
		while(low<=high){
			
			mid=(low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}			
		}				
		System.out.println(ans);
	}	
	

}
