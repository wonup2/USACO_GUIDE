import java.io.*;
import java.util.*;


public class perimeter {
	static BufferedReader in;
	static PrintWriter out;
	static int N, count, max, minP, perimeter;
	static boolean[][] grid, used;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("perimeter.in"));
		out = new PrintWriter("perimeter.out");
		init();
		
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		N = Integer.parseInt(in.readLine());
		grid = new boolean[N][N];
		used = new boolean[N][N];
		
		for(int i = 0; i < N; i++){
			String s = in.readLine();
			for(int j = 0; j < N; j++) {
				if(s.charAt(j) == '#') {
					grid[i][j] = true;
				}
				
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j]&&!used[i][j]) {
					count = 0; perimeter = 0;
					dfs(i, j);
					
					if(count > max) {
						max = count;
						minP = perimeter;
					} else if(count == max && perimeter < minP) {
						minP = perimeter;
					}
				}
			}
		}
		
		out.println(max + " " + minP);
	
		
	}
	
	static void dfs(int r, int c) {
		if(r >= N || r < 0 || c >= N || c < 0 || !grid[r][c]) {
			perimeter++;
			return;
		}
		if(used[r][c]) {
			return;
		}
		
		
		used[r][c] = true;
		count++;
		
		dfs(r, c+1);
		dfs(r, c-1);
		dfs(r+1, c);
		dfs(r-1, c);

		
	}
}