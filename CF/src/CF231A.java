import java.util.*;
import java.io.*;

public class CF231A {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;

	static int n, a, b, c, cnt, ans;

	public static void main(String[] args) throws IOException {

		//in = new Scanner(new File("temp.in"));		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		n = Integer.parseInt(in.readLine());
		ans = 0;
		
	}
	
	static void solve() throws IOException {
	
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());   //1 1 0
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			if(a==1) cnt++;
			if(b==1) cnt++;
			if(c==1) cnt++;
			
			if(cnt>=2) ans++;
		}
		
		System.out.println(ans);
	}

}
