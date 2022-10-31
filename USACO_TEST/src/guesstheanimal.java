import java.util.*;
import java.io.*;

public class guesstheanimal {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n;

	static ArrayList<String>[] a;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) a[i].add(st.nextToken());
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int max=0;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				int cnt=1;
				for(String s:a[i]) 
					if(a[j].contains(s)) cnt++;
				
				System.out.println(cnt);
				max=Math.max(max, cnt);		
			}
		}	
		out.println(max);
	}

}