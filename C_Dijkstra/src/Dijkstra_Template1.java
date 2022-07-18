import java.util.*;

//O(N^2)
public class Dijkstra_Template1 {
	static Scanner in;
	static int n, m, a[][], d[], INF=100000000;
	static boolean v[];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][n];
		d = new int[n];
		v = new boolean[n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = INF;
				if(i==j) a[i][j] = 0;				
			}
		}
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int w = in.nextInt();
			a[x][y] = w;
			a[y][x] = w;
		}		
	}
	
	static void solve() {
		int start = 0;
				
		dijkstra(start);
		
		System.out.println(Arrays.toString(d));
	}
	
	static void dijkstra(int s) {
		
		for(int i=0; i<n; i++) d[i] = a[s][i];

		v[s] = true;
		
		for(int i=0; i<n; i++) {
			int cur = getMinIndex();
			v[cur] = true;

			for(int j=0; j<n; j++)			
				if(!v[j]) d[j] = Math.min(d[j], d[cur] + a[cur][j]);	
		}
	}

	static int getMinIndex() {
		int min = INF;
		int index = 0;
		for(int i=0; i<n; i++) {
			if(!v[i] && d[i]<min && d[i]!=0) {
				min = d[i];
				index = i;
			}
		}		
		return index;
	}
}

/*
0  3  6  7
3  0  1 INF
6  1  0  1
7 INF 1  0

4 5
1 2 3
1 3 6
1 4 7
2 3 1
3 4 1
*/ 
