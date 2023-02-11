//Adjacency Graph - How many islands?
/*
4 5
1 1 1 0 0
1 1 0 0 1
1 0 0 1 1
0 0 1 0 0

3
*/
import java.util.*; 
public class _DFS_Template1{
	
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int a[][], n, m, cnt;
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
		in.close();		
	}
	
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) 
				a[i][j] = in.nextInt();		
	}
	
	static void solve() {
	
		cnt=0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) 
				if(a[i][j]==1) {
					dfs(i,j);					
					cnt++;					
				}
					
		System.out.println(cnt);
	}
		
	static void dfs(int r, int c) {
	
		a[r][c]=0;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0||nc<0||nr>=n||nc>=m||a[nr][nc]==0) continue;
			
			dfs(nr, nc);			
		}
	}
}


/*
5 5
0 0 0 0 0 
0 0 1 0 0 
0 1 0 1 0 
0 1 0 1 1
0 0 0 0 1

*/