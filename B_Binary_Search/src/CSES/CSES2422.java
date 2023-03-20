package CSES;

import java.util.*;

public class CSES2422 {
	static Scanner in;
	static long n;
	
	static long check(long x){
	    long cnt = 0;
	    for(long i = 1; i <= n; i++)
	        cnt += Math.min(n, x/i);
	    return cnt;
	}
	
	public static void main(String[] args){
	    in = new Scanner(System.in);
	    
	    n = in.nextLong();
	    long low = 0l;
	    long high = n*n;
	    long mid = 0l, ans=0l;
	    
	    while(low<=high){
	        mid = (low+high)/2;
	        if(check(mid) < (n*n+1)/2) {
	        	ans = mid;
	        	low = mid+1;
	        }
	        else high = mid-1;
	    }
	    System.out.println(ans+1);
	}
}

