import java.util.*;
import java.io.*;

public class CF1365_maze {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, dx[] = {0, 0, -1, 1}, dy[]= {-1, 1, 0, 0};
	static char a[][];
	static boolean v[][];

	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			System.out.println(solve());
		}
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		v = new boolean[n][m];
		
		for(int i=0; i<n; i++) 
			a[i] = in.readLine().toCharArray();
		
	}

	static String solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]=='B') {

					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(a[nx][ny]=='G') return "No";
						if(a[nx][ny]=='.') a[nx][ny]='#';
							
					}
				}
			}
		}
		
		
		if(a[n-1][m-1] != '#') ff(n-1, m-1);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]=='G' && !v[i][j]) return "No";
			}
		}
		
		return "Yes";
	}
	
	static void ff(int i, int j) {
		
		if(i<0||j<0||i>=n||j>=m||v[i][j]||a[i][j]=='#') return;
		
		v[i][j] = true;
		
		ff(i, j+1);
		ff(i, j-1);
		ff(i+1, j);
		ff(i-1, j);
		
	}
}
