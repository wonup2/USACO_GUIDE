import java.util.*;
import java.io.*;

public class U19Feb_MeasuringTraffic {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, l[], r[];
	static String d[];

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
		l = new int[n];
		r = new int[n];
		d = new String[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			d[i] = st.nextToken();
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		
		
		int L = -999999999;
	    int R = 999999999;
	    
	    for(int i=n-1; i>=0; i--) {
	    	
	    	if(d[i].equals("none")) {
	    		L = Math.max(L, l[i]);
	    		R = Math.min(R, r[i]);
	    	}

	    	else if(d[i].equals("off")) {
	    		L += l[i];
	    		R += r[i];
	    	}
	    	
	    	else {
	    		L -= r[i];
	    		R -= l[i];
	    		
	    		if(L<0) L =0;
	    	}
	    	
	    }
	    
	    System.out.println(L+" "+R);
	    
	    L = -999999999;
	    R = 999999999;
	    
	    for(int i=0; i<n; i++) {
	    	
	    	if(d[i].equals("none")) {
	    		L = Math.max(L, l[i]);
	    		R = Math.min(R, r[i]);
	    	}

	    	else if(d[i].equals("on")) {
	    		L += l[i];
	    		R += r[i];
	    	}
	    	
	    	else {
	    		L -= r[i];
	    		R -= l[i];
	    		
	    		if(L<0) L =0;
	    	}
	    	
	    }
	    
	    System.out.println(L+" "+R);
		
	}

}