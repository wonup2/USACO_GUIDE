import java.io.*;
import java.util.*;

public class BS_Template {	

	public static void init() {
		n=0; m=0; a=new int[n]; low=0; high=100000;
	}
	
	public static void solve() {
		
		ans = 0;
		int mid = 0;
		
		while(low<=high){
			mid=(low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}			
		}		
		
		System.out.println(ans);
	}	
	
	static boolean check(int mid) {
		
		int c=1;
//		for() {
//			
//		}
		
		return c <= mid;
	}
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static int n, m, a[], ans, low, high;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("xxx.in"));
		out = new PrintWriter(new PrintWriter("xxx.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
}
