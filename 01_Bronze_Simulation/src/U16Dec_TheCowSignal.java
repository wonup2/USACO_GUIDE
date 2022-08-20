import java.util.*;
import java.io.*;

public class U16Dec_TheCowSignal {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "cowsignal";
	static int m, n, k;

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
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}
	
	static void solve() throws IOException {
		
		String ans="";
		for(int i=0; i<m; i++) {
			String s = in.readLine();
			String line = "";
			for(int j=0; j<n; j++) 
				for(int h=0; h<k; h++) line+=s.charAt(j);
				
			for(int h=0; h<k; h++) ans+=line+"\n";			
		}
				
		out.print(ans);	
	}

}