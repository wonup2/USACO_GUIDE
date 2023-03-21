import java.util.*;

public class dijkstra1 {
	static Scanner in;
	static int n, m, s, a[][], d[], INF = 1000000000;
	static boolean v[];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt()-1;
		a = new int[n][n];
		
		for(int i = 0; i<n; i++)
			for(int j=0; j<n; j++)
				if(i!=j) a[i][j] = INF;
		
		for(int j = 0; j<m; j++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int w = in.nextInt();  
			a[x][y] = w;
			//a[y][x] = w;			
		}

		v = new boolean[n];
		d = new int[n];
		
	}

	static void solve() {		
		dijkstra();
		System.out.println(Arrays.toString(d));

	}
	
	static void dijkstra() {
		
		v[s] = true;
		d = a[s].clone(); 
		
		for(int i=0; i<n; i++) {
			int cur = getMinIdx();  
			
			for(int j=0; j<n; j++) {
				if(v[j] || i==j) continue;
				d[j] = Math.min(d[j], d[cur]+a[cur][j]);
				v[j] = true;
			}
		}
	}
	
	static int getMinIdx() {

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

4 5 1
1 2 3
1 3 6
1 4 7
2 3 1
3 4 1


*/ 