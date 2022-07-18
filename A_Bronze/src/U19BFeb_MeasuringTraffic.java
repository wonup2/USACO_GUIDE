import java.util.*;
import java.io.*;

public class U19BFeb_MeasuringTraffic {

	static BufferedReader in;
	static PrintWriter out;
	static String f = "traffic";
	static StringTokenizer st;	
	static int n, a[], b[];
	static String c[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		b = new int[n];
		c = new String[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			c[i] = st.nextToken();
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		int left = -999999999;
		int right = 999999999;

		for(int i=n-1; i>=0; i--) {
			if(c[i].equals("on")) {
				left -=b[i]; 
				right -=a[i];
				if(left<0) left = 0;
			}
			else if(c[i].equals("off")){
				left +=a[i];
				right +=b[i];
			}
			else {
				left = Math.max(left, a[i]);
				right = Math.min(right, b[i]);
			}
		}
		
		out.println(left+" "+right);

		for(int i=0; i<n; i++) {
			if(c[i].equals("off")) {
				left -=b[i]; 
				right -=a[i];
				if(left<0) left = 0;
			}
			else if(c[i].equals("on")){
				left +=a[i];
				right +=b[i];
			}
			else {
				left = Math.max(left, a[i]);
				right = Math.min(right, b[i]);
			}
		}
		out.println(left+" "+right);

	}

}