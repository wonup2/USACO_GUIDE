package USACO;
import java.util.*;
import java.io.*;

public class U14_JAN_SIL_ccski {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, a[][], b[][], dx[]= {0, 0, -1, 1}, dy[]= {-1, 1, 0, 0};
	static boolean v[][];
	
	
	
	static void dfs(int x, int y, int d) {
		
		v[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=n||ny>=m||v[nx][ny]||Math.abs(a[nx][ny]-a[x][y])>d) continue;
			dfs(nx, ny, d);
		}
	}
	
	static boolean check(int d) {
		v = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			boolean found = false;
			for(int j = 0; j<m; j++) {
				
				if(b[i][j]==1) {
					found = true;
					dfs(i, j, d);
					break;
				}
			}
			if(found) break;
		}
		
		for(int i=0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(b[i][j]==1 && !v[i][j]) return false;
			}
		}
				
		return true;
	}
	static void solve() {
		
		int low = 0;
		int high = 1000000000;
		int ans = 0;
		
		while(low<=high) {
			
			int mid = low+high / 2;
			if(check(mid)) {
				ans = mid;
				high = mid -1;
			}
			else low = mid+1;
		}
		
		out.println(ans);
	}
	
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		for(int i=0; i<n; i++)
			a[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		b = new int[n][m];
		for(int i=0; i<n; i++)
			b[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

	}
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("ccski.in"));
		out = new PrintWriter(new FileWriter("ccski.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

}
