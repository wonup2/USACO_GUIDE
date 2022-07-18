import java.io.*;
import java.util.*;

//2D prefix sum

public class CSES1652 {
	static BufferedReader in;
	static int n,m,x[][],a,b,c,d, ans;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		x = new int[n+1][n+1];
		
		fill();
		solve();
	}
	
	static void fill() throws IOException {		
		
		for(int i=1; i<=n; i++) {
			
			char[] tree = in.readLine().toCharArray();
			
			for(int j=1; j<=n; j++) {
				
				x[i][j] = tree[j-1]=='*' ? 1:0;
				x[i][j] = x[i][j] + x[i-1][j] + x[i][j-1] - x[i-1][j-1];
			}
		}		
	}
	
	static void solve() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			ans = x[c][d] - x[a-1][d] - x[c][b-1] + x[a-1][b-1];
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
