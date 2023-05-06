import java.util.*;
import java.io.*;

public class US17_JAN_SIL_hps {

	static BufferedReader in;
	static PrintWriter out;
	static int n, x[], a[][], b[][], ans;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("hps.in"));
		out = new PrintWriter(new File("hps.out"));
		init();
		solve();		
		in.close();
		out.close();
	}

	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		x = new int[n];
		a = new int[n][3];
		b = new int[n][3];
		
		for(int i=0; i<n; i++) x[i] = conv(in.readLine().charAt(0));
			
		a[0][x[0]]++;
		b[n-1][x[n-1]]++;
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				a[i][j] = a[i-1][j];
				b[n-i-1][j] = b[n-i][j];
			}
			a[i][x[i]]++;	
			b[n-i-1][x[n-i-1]]++;
		}
	}
	
	static void solve() {
		
		for(int i=0; i<n-1; i++) 
			ans = Math.max(ans, max(i, a)+max(i+1, b));
		
		out.println(ans);
	}
	
	static int max(int i, int a[][]) {
		return Math.max(a[i][0], Math.max(a[i][1], a[i][2]));
	}
	
	static int conv(char c) {
		if(c=='P') return 0;
		else if(c=='H') return 1;
		else return 2;
	}
}
