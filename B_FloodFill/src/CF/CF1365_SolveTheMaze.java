package CF;
import java.io.*;
import java.util.*;

public class CF1365_SolveTheMaze {
	
	static Scanner in;
	static int[] dr = {0, 1, 0, -1};  // right, down, left, up
	static int[] dc = {1, 0, -1, 0};
	static char[][] a;
	static boolean[][] v;
	static int n;
	static int m;

	static void floodfill(int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 4; i++) {  
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx < 0 || nx >= n || ny <0 || ny >=m  || v[nx][ny] || a[nx][ny] == '#') continue;
			floodfill(nx, ny);				
		}
	}

	static String solve() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if (a[i][j] == 'B') {
					for (int x = 0; x < 4; x++) {  
						int nx = i + dr[x];
						int ny = j + dc[x];

						if (nx < 0 || nx >= n || ny <0 || ny >=m ) continue;
						if (a[nx][ny] == 'G') return "No"; 
						if (a[nx][ny] == '.') a[nx][ny] = '#';							
						
					}
				}
			}
		}

		if (a[n - 1][m - 1] != '#') 
			floodfill(n - 1, m - 1);
		

		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++) 
				if (a[i][j] == 'G' && !v[i][j]) return "No";			
		
		
		return "Yes";
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new char[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) 
			a[i] = in.next().toCharArray();			
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-->0) {
			init();
			System.out.println(solve());
		}
		
		in.close();
	}	
}