package USACO;
//USACO 2018 December Silver convention

import java.io.*;
import java.util.*;

public class C_Convention {

	static int a[], n, m, c, ans;
	
	static boolean f(int mid) {
	    int s = 0, start = a[0], bus = 1, cow = 0;
	    
	    for (int i = 0; i < n; i++) {
	    	s = a[i]-start; 
	    	cow++;
	        if (cow > c || s > mid) { start = a[i]; bus++; cow=1;}
	    }
	    return bus <= m ;
	} 
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new FileWriter("convention.out"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    a=new int[n];    
	    
	    st = new StringTokenizer(in.readLine());
	    for (int i = 0; i < n; i++) a[i]=Integer.parseInt(st.nextToken());
	    
	    Arrays.sort(a);
	  
	    int low = 0, up = a[n-1]*2, mid = 0;  //<--- most important part
	    while (low <= up) {
	        mid = (up+low) / 2;	
	        if(f(mid)) {
	        	ans = mid;
	        	up = mid-1;
	        }
	        else low = mid + 1;	    	
	    }
	    
	   out.println(ans);
	   out.close();
	   in.close();
	}
}