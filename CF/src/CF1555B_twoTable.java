import java.util.*;
import java.io.*;

public class CF1555B_twoTable {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, wr, hr, x1, y1, x2, y2, w1, h1, w2, h2, s1, s2, moveW, moveH, ans;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		while(n-->0) {
			init();
			solve();
		}
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		st = new StringTokenizer(in.readLine());
		wr = Integer.parseInt(st.nextToken());
		hr = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		w2 = Integer.parseInt(st.nextToken());
		h2 = Integer.parseInt(st.nextToken());
				
		w1 = x2-x1;
		h1 = y2-y1;
		
		ans = Integer.MAX_VALUE;
	}
	
	static void solve() throws IOException {
		
		if(w1+w2>wr && h1+h2>hr) ans = -1;
		else {		
			if(w1+w2<=wr) {
				s1 = x1;
				s2 = wr-x2;
				if(s1>=w2 || s2>=w2) ans = 0;
				else ans = Math.min(w2-s1, w2-s2);	
			}
			if(h1+h2<=hr) {
				s1 = y1;
				s2 = hr-y2;

				if(s1>=h2 || s2>=h2) ans = 0;
				else ans = Math.min(ans, Math.min(h2-s1, h2-s2));
			}
		}
		
		System.out.println(ans);
	}
}
