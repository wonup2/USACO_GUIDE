package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 4963 사방 팔방

import java.util.*;

public class BFS15 {

	static BufferedReader in;
	static StringTokenizer st;
	
	static int n, m, a[][];
	static Queue<Integer> q;

	static int dx[]= {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[]= {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if(n==0) break;
			init();
			solve();
		}
		in.close();			
	}
	
	static void init() throws IOException {

		a = new int[n][m];
		
		if(n==1&&m==1) a[0][0] = Integer.parseInt(in.readLine());
		else 
			for (int r = 0; r < n; r++) 	
				a[r] = Arrays.stream(in.readLine().split(" "))
					         .mapToInt(Integer::parseInt).toArray();		
	}
	
	static void solve() {
		int cnt = 0;
		q = new LinkedList<Integer>();
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
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
		a[x][y]=0;
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m||a[nx][ny]==0) continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny]=0;
			}
		}
	}
}


/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0



0
1
1
3
1
9
*/