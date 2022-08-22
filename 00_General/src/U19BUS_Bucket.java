import java.util.*;
import java.io.*;


public class U19BUS_Bucket {

	static Scanner in;
	static PrintWriter out;
	static int br, bc, rr, rc, lr, lc;
	static char a[][];
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);

		in = new Scanner(new File("buckets.in"));
		out = new PrintWriter(new File("buckets.out"));
						
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		
		for (int i=0; i<10; i++) {
			String s = in.nextLine();
			
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='B') {
						br = i;
						bc = j;
				}
				else if(s.charAt(j)=='R') {
						rr = i;
						rc = j;
				}
				else if(s.charAt(j)=='L') {
						lr = i;
						lc = j;
				}
			}
		}		
	}

	static void solve() {		
		
		int ans = Math.abs(br-lr) + Math.abs(bc-lc)-1;
		
		if(check()) ans += 2;				
		
		out.println(ans);
	}
	
	static boolean check() {
		return (lr==rr && rr==br && (lc<rc && rc<bc || bc<rc && rc<lc)) || 
				(lc==rc && rc==bc && (lr<rr && rr<br || br<rr && rr<lr));
		
	}
}
