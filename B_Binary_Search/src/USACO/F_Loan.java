package USACO;
import java.util.*;
import java.io.*;

public class F_Loan {
	static BufferedReader in;
	static PrintWriter out;
	static long N,M,K;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("loan.in"));
		PrintWriter out = new PrintWriter(new File("loan.out"));
	    N = in.nextLong();
	    K = in.nextLong();
	    M = in.nextLong();
		long low = 1, high = N, ans = 0;
		while (low <= high) {
		    long mid = (low + high)/2;
		    if (check(mid)) {
		    	ans = mid;
		    	low = mid + 1; 
		    }
		    else high = mid-1;
		}		
		out.println(ans);
		out.close();
	}
		
	static boolean check(long x) {
		long days = K;
		long left = N;
		while (true) {
			long y = left/x;
		    if (y <= M) return M * days >= left; 	//Math

		    long jump = (left % x)/y + 1;  			//Jump
		    days -= jump;
		    left -= y*jump;
		    
		    if(days<=0) break;
		}
		return left <= 0;
	}
}
