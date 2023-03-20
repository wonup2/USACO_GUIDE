package BJ;
//연구소
//https://www.acmicpc.net/problem/14502

import java.util.*;
 
class virus {
    int y;
    int x;
 
    public virus(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
 
public class B14502 {
 
	static Scanner in;
    static int n, m;
    static int[][] a;
    static boolean[][] v;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
 
    public static void main(String[] args){
    	in = new Scanner(System.in);
        
        n = in.nextInt();
        m = in.nextInt();
        a = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                a[i][j] = in.nextInt();
        
        dfs(0);
 
        System.out.println(ans);
    }
 
    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    a[i][j] = 1;
                    dfs(depth + 1);
                    a[i][j] = 0;
                }
            }
        }
    }
 
    public static void bfs() {
        int[][] virus = new int[n][m];
        Queue<virus> queue = new ArrayDeque<>();
 
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) {
            	virus[i][j] = a[i][j];   
            	if (virus[i][j] == 2) 
                    queue.add(new virus(i, j));
            }
        
        while (!queue.isEmpty()) {
            virus poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (virus[ny][nx] == 0) {
                	virus[ny][nx] = 2;
                    queue.add(new virus(ny, nx));
                }                
            }
        }
        count(virus);
    }
 
    public static void count(int[][] virus) {
        int temp = 0;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (virus[i][j] == 0) temp++;
                
        ans = Math.max(ans, temp);
    }
}