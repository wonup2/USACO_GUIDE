import java.util.*;
import java.io.*;

public class US19_FEB_BR_traffic {

	static BufferedReader in;
	static StringTokenizer st;	
	
	static PrintWriter out;

	static String f = "traffic";
	static int n, a[], b[];
	static String s[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		
		//in = new BufferedReader(new InputStreamReader(System.in));
				
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		
		s = new String[n];
		a = new int[n];
		b = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());

			s[i] = st.nextToken();
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(s));
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		int maxA = -100000;
		int minB = 100000;
		
		
		for(int i=n-1; i>=0; i--) {
			if(s[i].equals("none")) {
				maxA = Math.max(maxA, a[i]);
				minB = Math.min(minB, b[i]);				
			}
			
			else if (s[i].equals("on")) {
				maxA -= b[i];
				minB -= a[i];
				
				maxA = maxA<0? 0:maxA;
			}
			else {
				maxA += a[i];
				minB += b[i];
			}
		}
		
		out.println(maxA+" "+ minB);
		
		maxA = -1001;
		minB = 1001;
		for(int i=0; i<n; i++) {
			if(s[i].equals("none")) {
				maxA = Math.max(maxA, a[i]);
				minB = Math.min(minB, b[i]);				
			}
			
			else if (s[i].equals("off")) {
				maxA -= b[i];
				minB -= a[i];
				
				maxA = maxA<0? 0:maxA;
			}
			else {
				maxA += a[i];
				minB += b[i];
			}
		}
		out.println(maxA+" "+ minB);
	}

}