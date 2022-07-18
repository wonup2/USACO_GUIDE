import java.util.*;

public class BFS_Template2 {

	static int n, m;
	static char a[][];
	static Queue<Integer> q;
	static Scanner in;
	static int dr[]= {-1, 1, 0, 0};
	static int dc[]= {0, 0, -1, 1};
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();			
	}
	
	static void init() {

		m = in.nextInt();
		n = in.nextInt();
		a = new char[n][m];
		for(int i=0; i<n; i++) 
			a[i] = in.next().toCharArray();
			
		q = new LinkedList<Integer>();
	}
	
	static void solve() {
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]=='1') {
					bfs(i,j);
					cnt++; 
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			if(a[x][y]=='0') continue;

			a[x][y] = '0';
			for(int i=0; i<4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if(nx<0||nx>=n||ny<0||ny>=m||a[nx][ny]=='0') continue;
				q.add(nx);
				q.add(ny);
			}
		}
	}
}

/*
5 4
10100
10000
10111
10010

3
*/
